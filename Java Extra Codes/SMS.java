
SMS.java
 // Demo for sending SMS via a serial PC connection and a mobile phone
//
// This programm establish with AT commands a communication between
// a PC and a mobile phone. It sends and receives SMS from the mobile phone.
//
// file: SMS.java
// uses: SMSTools.java
//
// This program uses the javax.comm Service from Sun to transfer data via the
// serial PC port. Testet with Nokia 6210 on port COM 1 in German D1 GSM net.
//
// The AT commands for mobile telephone are specified in the ETSI standards:
//   TS 07.07  AT command set for GSM Mobile Equipment (ME)
//   TS 27.007 AT command set for 3G User Equipment (UE)
//
// Useful tool for PDU analysing : pduspy.exe
// Remark: Before starting this programm you have to adopt SMSDIALNO, EMAILDIALNO, EMAILADR
//         to your personal values.
//
// 28. May   2003 - V 6, rw: source simplifed and reviewed, 1st published version
// 15. May   2003 - V 5, rw: improved documentation and clarifications
// 24. April 2003 - V 4, rw: code review, optimisation of read(), improved documentation
//  9. Jan.  2003 - V 3, rw: add method sendAT(...)
// 20. Dec.  2002 - V 2, rw: improved documentation
// 19. Dec.  2002 - V 1, rw: initial runnable version
//---------------------------------------------------------------------------------------

package SMSDemo;

import java.util.*;
import java.text.*;
import java.io.*;
import java.rmi.*;
import javax.comm.*;

public class SMS {
  private static String portName;
  private static SerialPort port;
  private static OutputStreamWriter out;
  private static InputStreamReader in;
  static final boolean DEBUG = false;               // true -> show some debug information
  static final boolean NATIONAL = true;             // it is a national dialing number
  static final boolean INTERNATIONAL = false;       // it is a international dialing number
  static final String SMSDIALNO = "0160711????";    // dialing number for SMS transmission
  static final String EMAILDIALNO = "8000";         // dialing number for eMail transmission
  static final String EMAILADR = "wolfgang.rankl@????.de";  // eMail adress

  /** open the connection via the serial line
  * @return  ---
  * @throws java.rmi.RemoteException remote exception
  */
  SMS() throws java.rmi.RemoteException {
    String appName, portName;

    appName = "SMS";
    portName = "COM1";
    this.portName = portName;
    port = null;
    out = null;
    in = null;

    try {
      CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portName);
      port = (SerialPort)portId.open(appName, 5000);  // open port
      if (DEBUG == true) showText("open port " + portName);

      // set parameter for serial port
      port.setSerialPortParams(19200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
      out = new OutputStreamWriter(port.getOutputStream(), "ISO-8859-1");
      in = new InputStreamReader(port.getInputStream(), "ISO-8859-1");
    } // try
    catch (Exception x) {
      showText("could not open port:"  + x);
      System.exit(0);
    } // catch
  } // SMS

  /** show text in the text window
   *  @param Text text string to show on the display
   */
  public static void showText(String Text) {
    System.out.println(Text);
  } // showText

  /** creates a Windows conform formated date and time string
   *  @return: data and time string
   */
  public static String getFormatedDateTime() {
    String s;
    Date t = new Date();
    t.getTime();
    s = DateFormat.getDateTimeInstance().format(t);
    return s;
  } //  getFormatedDateTime

  /** close the connection via the serial line
  */
  public static void close() {
    if (port != null) {
      try {
        if (DEBUG == true) showText("close port " + portName);
        port.close();
      } // try
      catch (Exception x) {
      showText("close port failed: " + x);
      } // catch
    } // if
  } // close

  /** sends an AT command to ME and receives the answer of the ME
   * @param atcommand AT command for the mobile phone
   * @return  answer string of the ME
   * @throws java.rmi.RemoteException
   */
  public static String sendAT(String atcommand) throws java.rmi.RemoteException {
    String s="";
    SMS sms = new SMS();

    try {
      writeln("AT");  // ensure that there is a working communication
      read();
      writeln(atcommand);   // send AT command to ME
      s = read();           // get response from ME
    } // try
    catch (Exception x) {
      showText("send AT command failed; " + "Command: " + atcommand + "; Answer: " + s + "  " + x);
    } // catch
    close();
    return s;
  }  // sendAT

  /** get SMS from the ME
   *  @param  smsnumber number of SMS
   *  @return  SMS string of the ME
   *  @throws Exception
   */
  public static String getSMS(int smsnumber) throws Exception {
    String s="";
    try {
      s = sendAT ("AT+cmgr=" + smsnumber);
    } // try
    catch (Exception x) {
      showText("get SMS failed: " + x);
    } // catch
    return s;
  } // getSMS

  /** deletes a SMS from the ME
   *  @param smsnumber number of SMS
   *  @throws Exception
   */
  public static void deleteSMS(int smsnumber) throws Exception {
    String s="";
    try {
      s = sendAT ("AT+cmgd=" + smsnumber);
    } // try
    catch (Exception x) {
      showText("delete SMS failed: " + x);
    } // catch
  } // deleteSMS

  /** get number of stored SMS from the ME
   *  @return  number of stored SMS in the ME
   *  @throws Exception
   */
  public static int getNoOfSMS() throws Exception {
    int n, p;
    String s = "";
    try {
      s = sendAT ("AT+cmgl=?");
    } // try
    catch (Exception x) {
      showText("get number of SMS failed: " + x);
    } // catch

    // get the number of SMS from the answer string
    // example of answer: "+CMGL: (0,4)"
    if (s.length()>0) {
      p = s.indexOf(",");
      s = s.substring(p+1, s.length());
      p = s.indexOf(")");
      s = s.substring(0, p);
      n = Integer.parseInt(s.trim());
    }
    else
      n = 0;
    return n;
  } // getNoOfSMS

  public static void sendSMS(String dialno, boolean notype, String smstext)
      throws java.rmi.RemoteException {

    // message will be restricted to 160 characters
    if (smstext.length() > 160) {
      smstext = smstext.substring(0, 160);
      showText("Warning: SMS shorten to 160 characters");
    }

    showText("Dialing Number: " + dialno);
    showText("Message:        " + smstext);

    //--- build PDU ---
    SMS sms = new SMS();
    SMSTools smstools = new SMSTools(dialno, notype, smstext);
    byte[] pdu = SMSTools.getPDU();

    //--- send ---
    try {
      writeln("AT");  // ensure that there is a working communication
      read();
      writeln("AT+CMGF=0");              // set message format to PDU mode
      read();
      writeln("AT+CMGS=" + pdu.length);  // set length of PDU
      read();
      write("00");                       // set ???
      write(SMSTools.toHexString(pdu));  // set PDU
      write("\u001A");                   // set Ctrl-Z = end of PDU
      read();
    } // try
    catch (Exception x) {
      showText("send failed: " + x);
    } // catch
    close();
  }  // sendSMS

 /** write a string to the output buffer
  *  @param s string for the serial output buffer
  *  @throws Exception
  */
  private static void write(String s) throws Exception {
    out.write(s);
    out.flush();
  }  // write

  /** write a character to the output buffer
   *  @param s character for the serial output buffer
   *  @throws Exception
   */
  private static void write(char[] s) throws Exception {
    out.write(s);
    out.flush();
  }  // write

 /** write a string with CR at the end to the output buffer
  *  @param s string for the serial output buffer
  *  @throws  Exception
  */
  private static void writeln(String s) throws Exception {
    out.write(s);
    out.write('\r');
    out.flush();
  }  // write

  /** receives a character string from the serial line from the
    * beginning till an end of message indicator
    * @return  received character string from ME
    * @throws Exception
    */
  private static String read() throws Exception {
    int n, p, l;
    char c;
    StringBuffer buf;
    buf = new StringBuffer("");
    String answer = new String("");
    for (int i = 0; i < 5; i++) {  // look 5 times for character string to receive; 5*100 msec
      while (in.ready()) {         // collect all characters from the serial line
        n = in.read();             // get 1 character from the serial line
        if (n != -1) {             // character received
          c = (char)n;
          if (c == '\r' || c == '\n') {     // end of message indicator (CR, LF)
            if (buf.length() > 0) {         // buffer have a content
              answer = answer + "\n" + buf.toString();    // collect the answers from ME
              buf = new StringBuffer("");   // create a new emty buffer
            } // if
          } // if
          else  {            // it is not the end of the message
            buf.append(c);   // add received character to buffer
          } // else
        } // if
      } // while
      Thread.sleep(100);     // wait 100 msec
    }  // for

    // now do some formating of the received character string
    if (answer.length()>0) {
      p = answer.indexOf("OK");              // search "OK" (hopefully at the end of the answer)
      if (p != -1) {                         // "OK" found
        answer = answer.substring(0,p);      // delete all characters after "OK"
        p = answer.indexOf("\n");            // search LF at the beginning of the answer
        answer = answer.substring(p+1, answer.length());   // delete all characters before LF
      }  // if
      else {
        answer = "";
      }  // else
    }  // if
    return answer;  // give the received string back to the caller
  } // read

 /** main
  *  @param args there will be no arguments for the main
  */
  public static void main(String [] args){
    int n, i;
    String s;

    showText("Start Program SMS\n");
    try {
      n = getNoOfSMS();
      showText("No. of stored SMS in SIM: " + Integer.toString(n));
      for (i = 1; i <= n; i++) {
        s = getSMS(i);
        showText(s);
        showText(SMSTools.getSMSText(s));
      }  // for
      showText("Mobile Phone Modell: " + sendAT ("AT+CGMM"));  // get Modellinformation from ME
      showText("Battery Status:      " + sendAT ("AT+CBC"));   // get battery status from ME
      showText("Connection Status:   " + sendAT ("AT+CREG?")); // get connection status to GSM net from ME
      showText("Signal Quality:      " + sendAT ("AT+CSQ"));   // get signal quality from ME
      sendSMS (EMAILDIALNO, NATIONAL, EMAILADR + "Testmail, PC send time: " + getFormatedDateTime());
      sendSMS (SMSDIALNO, INTERNATIONAL, "Test-SMS, PC send time: " + getFormatedDateTime());
      sendSMS (EMAILDIALNO, NATIONAL, EMAILADR + " Testmail");
    }  // try
    catch (Exception x) {
      showText("Exception in Main: " + x);
    }  // catch
    showText("\nStop Program SMS");
    System.exit(0);
  } // main
} // class



