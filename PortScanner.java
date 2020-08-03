package portscanner;

import java.lang.*;
import java.net.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;


public class PortScanner {
    private int portMin;
    private int portMax;
    private String serverName;
    private String portsOpen;

    public PortScanner(int min, int max) {
        portMin = min;
        portMax = max;
    }

    //have user pick target server
    private void setServerName() {
        System.out.println("What is the name of the server you are scanning?: ");
        Scanner server = new Scanner(System.in);
        serverName = server.nextLine();

    }

    // Attempt to cycle through range and create string containing results
    private void setConnection() {
        StringBuilder resultBuilder =new StringBuilder("***Ports Open***\n");
        for (int i = portMin; i <= portMax; i++) {
            try {
                Socket connectionSocket = new Socket();
                connectionSocket.connect(new InetSocketAddress(serverName, i), 100);
                resultBuilder.append("Port "+ i + " is open!\n");
                connectionSocket.close();
            } catch (SocketTimeoutException exception) {
                ;
            }
              catch (IOException exception) {
                ;
            }
        }
        portsOpen = resultBuilder.toString();

    }

    public String showResults(){
        setServerName();
        setConnection();
        return portsOpen;
    }

}
