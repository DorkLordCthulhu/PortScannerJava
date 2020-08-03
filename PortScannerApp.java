package portscanner;

public class PortScannerApp {

    public static void main(String[] args) {
        portscanner.PortScanner go = new portscanner.PortScanner(ENTER MINIMUM PORT HERE, ENTER MAXIMUM PORT HERE);
        System.out.print(go.showResults());
    }
}
