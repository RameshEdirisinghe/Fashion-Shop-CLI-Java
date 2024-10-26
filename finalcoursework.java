import java.util.*;
class Customer{
    private String OderId;
    private String Contactnum;
    private String Tshirtsize;
    private int qty;
    private double amount;
    private int status;

    public Customer(){

    }
    public Customer(String OderId,String Contactnum,String Tshirtsize, int qty, double amount){
        this.OderId=OderId;
        this.Contactnum=Contactnum;
        this.Tshirtsize=Tshirtsize;
        this.qty=qty;
        this.amount=amount;
    }
    public void setValues(String OderId,String Contactnum,String Tshirtsize, int qty, double amount, int status){
        this.OderId=OderId;
        this.Contactnum=Contactnum;
        this.Tshirtsize=Tshirtsize;
        this.qty=qty;
        this.amount=amount;
        this.status=status;
    }
    public void setstatus(int status){
        this.status=status;
    }
    public String getOrdeId(){
        return OderId;
    }
    public String getContactnum(){
        return Contactnum;
    }
    public String getTshirtsize(){
        return Tshirtsize;
    }
    public int getqty(){
        return qty;
    }
    public double getamount(){
        return amount;
    }
    public int getstatus(){
        return status;
    }
}
class sort{
    private int qty;
    private String size;
    private double amount;


    public void setValues(String size, int qty, double amount){
        
        this.size=size;
        this.qty=qty;
        this.amount=amount;
    }

    public String getSize(){
        return size;
    }
    public int getqty(){
        return qty;
    }
    public double getamount(){
        return amount;
    }


}
class CustomerReport{
    
    private String Contactnum;
    private int qty;
    private double amount;


    public void setValues(String Contactnum, int qty, double amount){
        
        this.Contactnum=Contactnum;
        this.qty=qty;
        this.amount=amount;
    }

    public String getContactnum(){
        return Contactnum;
    }

    public int getqty(){
        return qty;
    }
    public double getamount(){
        return amount;
    }

}
class allcustomer{
    private String Contactnum;
    private int XS;
    private int S;
    private int M;
    private int L;
    private int XL;
    private int XXL;
    private double amount;

    public void setValues(String Contactnum, int XS,int S,int M,int L,int XL,int XXL, double amount){
        
        this.Contactnum=Contactnum;
        this.XS=XS;
        this.S=S;
        this.M=M;
        this.L=L;
        this.XL=XL;
        this.XXL=XXL;
        this.amount=amount;
    }

    public String getContactnum(){
        return Contactnum;
    }

    public int getXS(){
        return XS;
    }
    public int getS(){
        return S;
    }
    public int getM(){
        return M;
    }
    public int getL(){
        return L;
    }
    public int getXL(){
        return XL;
    }
    public int getXXL(){
        return XXL;
    }
    public double getamount(){
        return amount;
    }
    
}
class finalcoursework {
    public static Customer[] CusArray = new Customer[0];

    static int orderNumber = 0;
    static String newOrderID;
    static String contact;
    static int QTY;
    static double amount;
    static String tshirtsize;

    static String numberid;

    static int tempMcount = 0;
    static int tempScount = 0;
    static int tempXScount = 0;
    static int tempLcount = 0;
    static int tempXLcount = 0;
    static int tempXXLcount = 0;

    static double Mamount = 0;
    static double Samount = 0;
    static double XSamount = 0;
    static double Lamount = 0;
    static double XLamount = 0;
    static double XXLamount = 0;
    static double Totalamount = 0;

    static int Status = -1;
    static final int Processing = 0;
    static final int Delivering = 1;
    static final int Delivered = 2;

    static String searchoid;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println(
                " /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          ");
        System.out.println(
                "| $$_____/                | $$      |__/                           /$$__  $$| $$                          ");
        System.out.println(
                "| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
        System.out.println(
                "| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
        System.out.println(
                "| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
        System.out.println(
                "| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
        System.out.println(
                "| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
        System.out.println(
                "|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ ");
        System.out.println(
                "                                                                                                | $$      ");
        System.out.println(
                "                                                                                                | $$      ");
        System.out.println(
                "                                                                                                |__/      ");

        System.out.println(
                "\n\n_____________________________________________________________________________________________________________\n\n");

        System.out.println(
                "\t\t[1]place Order                                                      [2]Search Customrer\n");
        System.out.println("\t\t[3]Search Order                                                     [4]View Reports\n");
        System.out.println("\t\t[5]Set Order Status                                                 [6]Delete Order");

        System.out.print("\n\nInput Option : ");
        int Option = input.nextInt();

        switch (Option) {
            case 1:
                clearConsole();
                placeorder();
                break;
            case 2:
                clearConsole();
                SearchCustomer();
                break;
            case 3:
                clearConsole();
                SearchOrder();
                break;
            case 4:
                clearConsole();
                viewreports();
                break;
            case 5:
                clearConsole();
                // setorder();
                break;
            case 6:
                clearConsole();
                deleteorder();
                break;
            default:
                clearConsole();
                main(args);// if an invalid number is entered
                break;
        }

    }

    public static void placeorder() {

        System.out.println("  _____  _                   ____          _           ");
        System.out.println(" |  __ \\| |                 / __ \\        | |          ");
        System.out.println(" | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ ");
        System.out.println(" |  ___/| |/ _` |/ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println(" | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");

        System.out.println("\n\n_____________________________________________________________\n\n");

        Scanner input = new Scanner(System.in);

        orderNumber++; // global Variable & increment oder id number
        System.out.print("\n\n\nEnter Order ID :");
        String newOrderID = generateOrderID();
        System.out.println(newOrderID);

        customercontact(); // validate contact number

        Tshirtsize(); // validate t-shirt size

        EnterQty(); // check greater than Zero

        amount(); // genarate amount

        completeorder(); // get place order confirmation

        navigate();

    }

    public static String generateOrderID() {
        int tempOrderNumber = orderNumber;
        int[] tempNumOrder = new int[5];
        String idNum = "";
        String tag = "ODR#";
        newOrderID = "";
        for (int i = 4; tempOrderNumber > 0; i--) {
            tempNumOrder[i] = tempOrderNumber % 10;
            tempOrderNumber /= 10;
        }
        for (int i = 0; i < tempNumOrder.length; i++) {
            idNum += tempNumOrder[i];
        }
        newOrderID = tag + idNum;
        return newOrderID;
    }

    public static void customercontact() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer Number : ");
        contact = input.nextLine();

        if (contact.length() != 10 || contact.charAt(0) != '0') {
            System.out.println("\t\tinvalid phone number....Try again");
            System.out.print("Do you want to enter phone number again? (y/n) :");
            char yesno = input.next().charAt(0);

            if (yesno == 'y' || yesno == 'Y') {
                customercontact();
            } else if (yesno == 'N' || yesno == 'n') {
                main(null);
            }
        }

    }

    public static void Tshirtsize() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter T-shirt Size(XS/S/M/L/XL/XXL) :");
        tshirtsize = input.next().toUpperCase();

        if (!(tshirtsize.equals("XS") || tshirtsize.equals("S") || tshirtsize.equals("L") || tshirtsize.equals("XL")
                || tshirtsize.equals("M") || tshirtsize.equals("XXL"))) {

            System.out.print("\033[1A");
            System.out.print("\033[0J");
            Tshirtsize();
        }

    }

    public static void EnterQty() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter QTY : ");
        QTY = input.nextInt();
        if (QTY <= 0) {
            System.out.print("\033[1A");
            System.out.print("\033[0J");
            EnterQty();
        }
    }

    public static void amount() {
        Scanner input = new Scanner(System.in);

        switch (tshirtsize) {
            case "XS":
                amount = 600 * QTY;
                break;
            case "S":
                amount = 800 * QTY;
                break;
            case "M":
                amount = 900 * QTY;
                break;
            case "L":
                amount = 1000 * QTY;
                break;
            case "XL":
                amount = 1100 * QTY;
            case "XXL":
                amount = 1200 * QTY;
            default:
                break;
        }
        System.out.println("Amount : " + amount);

    }

    public static void completeorder() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to place this order(Y/N)");
        char yesno = input.next().charAt(0);
        if (yesno == 'y' || yesno == 'Y') {
            System.out.println("\tOrder Placed...!");
            Status = Processing;
            storedata();

        } else if (yesno == 'n' || yesno == 'N') {
            navigate();
        } else {
            System.out.print("\033[1A");
            System.out.print("\033[0J");
            completeorder();
        }

    }

    public static void storedata() {
        Customer[] tempCusArray = new Customer[CusArray.length+1];
        

        for (int i = 0; i < CusArray.length; i++) {
            // copy previous data
            tempCusArray[i] = CusArray[i];
        }
        tempCusArray[tempCusArray.length - 1] = new Customer();
        tempCusArray[tempCusArray.length-1].setValues(newOrderID, contact, tshirtsize, QTY, amount, Status); // Assign the new value to the last index
        CusArray = tempCusArray; 

    }

    public static void navigate() {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you wat to enter another order(y/N)");
        char yesno = input.next().charAt(0);
        if (yesno == 'y') {
            clearConsole();
            placeorder();
        } else if (yesno == 'n') {
            clearConsole();
            main(null);
        } else {
            System.out.print("\033[1A");
            System.out.print("\033[0J");
            navigate();
        }

    }

    public static void SearchCustomer() {
        System.out.println("   _____                     _        _____          _                            ");
        System.out.println("  / ____|                   | |      / ____|        | |                           ");
        System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ");
        System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|");
        System.out.println("  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   ");
        System.out
                .println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   ");

        System.out.println(
                "\n\n_________________________________________________________________________________________\n\n");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Customer Phone Number :");
        numberid = input.nextLine();
        searchcontact();

    }
    public static void searchcontact() {

        Scanner input = new Scanner(System.in);
    
        boolean isCorrect = false;
    
        for (int i = 0; i < CusArray.length; i++) {
    
            if (numberid.equals(CusArray[i].getContactnum())) {
                isCorrect = true;
                if (CusArray[i].getTshirtsize().equals("M")) {
                    tempMcount += CusArray[i].getqty();
                } else if (CusArray[i].getTshirtsize().equals("XS")) {
                    tempXScount += CusArray[i].getqty();
                } else if (CusArray[i].getTshirtsize().equals("S")) {
                    tempScount += CusArray[i].getqty();
                } else if (CusArray[i].getTshirtsize().equals("L")) {
                    tempLcount += CusArray[i].getqty();
                } else if (CusArray[i].getTshirtsize().equals("XL")) {
                    tempXLcount += CusArray[i].getqty();
                } else if (CusArray[i].getTshirtsize().equals("XXL")) {
                    tempXXLcount += CusArray[i].getqty();
                }
            }
    
        }
    
        if (!isCorrect) {
            System.out.println("Invalid Input... Customer not found.");
            System.out.print("Do you want to enter phone number again? (y/n): ");
            char yesno = input.next().charAt(0);
            if (yesno == 'y' || yesno == 'Y') {
                clearConsole();
                SearchCustomer(); // Call the method again to search
            } else {
                clearConsole();
                main(null); // Return to the main menu
            }
    
        } else {
            printresult();
    
        }
    
    }


    public static void printresult() {
        Mamount = tempMcount * 900;
        XLamount = tempXLcount * 1100;
        XXLamount = tempXXLcount * 1200;
        XSamount = tempXScount * 600;
        Samount = tempScount * 800;
        Lamount = tempLcount * 1000;
        Totalamount = Mamount + XLamount + XXLamount + XSamount + Samount + Lamount;

        System.out.printf("%-9s+%13s", "+------+-------", "------------+");
        System.out.printf("%-9s|%13s", "\n| Size | QTY   ", " Amount |");
        System.out.printf("%-9s+%13s", "\n+------+-------", "------------+");
        System.out.println();
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "M", tempMcount, Mamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "XL", tempXLcount, XLamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "XXL", tempXXLcount, XXLamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "XS", tempXScount, XSamount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "S", tempScount, Samount);
        System.out.printf("| %-4s | %-5d | %10.2f |\n", "L", tempLcount, Lamount);
        System.out.printf("+------+-------+------------+\n");
        System.out.printf("%-1s|%11.2f |", "| Total Amount ", Totalamount);
        System.out.printf("\n+--------------+------------+\n");

        Scanner input = new Scanner(System.in);
        System.out.print("Do you want to search phone number again? (y/n) :");
        char yesno = input.next().charAt(0);

        if (yesno == 'y' || yesno == 'Y') {
            clearConsole();
            updatecount();
            SearchCustomer();

        } else if (yesno == 'N' || yesno == 'n') {
            clearConsole();
            main(null);
        } else {
            System.out.print("\033[1A");
        }

    }

    public static void updatecount() {
        tempLcount = 0;
        tempMcount = 0;
        tempScount = 0;
        tempXLcount = 0;
        tempXScount = 0;
        tempXXLcount = 0;
    }

    public static void SearchOrder() {
        Scanner input = new Scanner(System.in);

        System.out.println("   _____                     _        ____          _           ");
        System.out.println("  / ____|                   | |      / __ \\        | |          ");
        System.out.println(" | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ ");
        System.out.println("  \\___ \\ / _ \\/ _` | '__/ __| '_ \\  | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println("  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   ");

        System.out.println("\n\n_____________________________________________________________\n\n");

        System.out.print("\nEnter Order ID :");
        searchoid = input.nextLine();

        searchoid();
    }

    public static void searchoid() {
        Scanner input = new Scanner(System.in);
        boolean istrue = false;
        for (int i = 0; i < CusArray.length; i++) {

            if (searchoid.equals(CusArray[i].getOrdeId())) {
                System.out.println("\nPhone number :" + CusArray[i].getContactnum());
                System.out.println("Size         :" + CusArray[i].getTshirtsize());
                System.out.println("QTY          :" + CusArray[i].getqty());
                System.out.println("Amount       :" + CusArray[i].getamount());
                if (CusArray[i].getstatus() == 0) {
                    System.out.println("Status       : Processing");
                } else if (CusArray[i].getamount() == 1) {
                    System.out.println("Status       : Delivering");
                } else if (CusArray[i].getamount() == 2) {
                    System.out.println("Status       : Delivered");
                }

                istrue = true;

                System.out.print("Do you want to search Oder ID again? (y/n) :");
                char yesno = input.next().charAt(0);

                if (yesno == 'y' || yesno == 'Y') {
                    clearConsole();
                    SearchOrder();
                } else if (yesno == 'N' || yesno == 'n') {
                    clearConsole();
                    main(null);
                } else {
                    System.out.print("\033[1A");
                }

            } else {
                continue;
            }

        }

        if (istrue == false) {
            System.out.println("Invalid Input...");
            System.out.print("Do you want to Search Oder ID again? (y/n) :");
            char yesno = input.next().charAt(0);

            if (yesno == 'y' || yesno == 'Y') {
                clearConsole();
                SearchOrder();
            } else if (yesno == 'N' || yesno == 'n') {
                clearConsole();
                main(null);
            } else {
                System.out.print("\033[1A");
            }
        }
    }

    public static void deleteorder() {
        Scanner input = new Scanner(System.in);

        System.out.println("  _____       _      _          ____          _           ");
        System.out.println(" |  __ \\     | |    | |        / __ \\        | |          ");
        System.out.println(" | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ ");
        System.out.println(" | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | '__/ _` |/ _ \\ '__|");
        System.out.println(" | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   ");
        System.out.println(" |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   ");

        System.out.println("\n\n_____________________________________________________________\n\n");

        boolean istruedelete = false;
        System.out.print("\nEnter Order ID :");
        searchoid = input.nextLine();

        for (int i = 0; i < CusArray.length; i++) {

            if (searchoid.equals(CusArray[i].getOrdeId())) {

                System.out.println("\nPhone number :" + CusArray[i].getContactnum());
                System.out.println("Size         :" + CusArray[i].getTshirtsize());
                System.out.println("QTY          :" + CusArray[i].getqty());
                System.out.println("Amount       :" + CusArray[i].getamount());
                if (CusArray[i].getstatus() == 0) {
                    System.out.println("Status       : Processing");
                } else if (CusArray[i].getamount() == 1) {
                    System.out.println("Status       : Delivering");
                } else if (CusArray[i].getamount() == 2) {
                    System.out.println("Status       : Delivered");
                }

                istruedelete = true;

                System.out.print("Do you want to Delete this order? (y/n) :");
                char yesno = input.next().charAt(0);

                if (yesno == 'y' || yesno == 'Y') {
                    System.out.println("\n\tOder Deleted...!");

                    sortarray(i);
                } else if (yesno == 'N' || yesno == 'n') {

                }

                System.out.print("Do you want to Delete another order? (y/n) :");
                yesno = input.next().charAt(0);

                if (yesno == 'y' || yesno == 'Y') {
                    clearConsole();
                    deleteorder();

                } else if (yesno == 'N' || yesno == 'n') {
                    clearConsole();
                    main(null);
                } else {
                    System.out.print("\033[1A");
                }

            }

        }

        if (istruedelete == false) {
            System.out.println("\tInvalid Input...");
            System.out.print("Do you want to enter another Oder ID? (y/n) :");
            char yesno = input.next().charAt(0);

            if (yesno == 'y' || yesno == 'Y') {
                clearConsole();
                deleteorder();
            } else if (yesno == 'N' || yesno == 'n') {
                clearConsole();
                main(null);
            } else {
                System.out.print("\033[1A");
            }
        }

    }

    public static void sortarray(int deleteindex) {
        Customer[] tempCusArray = new Customer[CusArray.length - 1]; // Correct size
    
        for (int i = 0, j = 0; i < CusArray.length; i++) {
            if (i != deleteindex) {
                tempCusArray[j] = CusArray[i]; // Copy valid entries
                j++;
            }
        }
        
        CusArray = tempCusArray; // Update the global array reference
    }

    public static void viewreports() {
        Scanner input = new Scanner(System.in);

        System.out.println("  _____                       _       ");
        System.out.println(" |  __ \\                     | |      ");
        System.out.println(" | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println(" |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println(" | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println(" |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("            | |                       ");
        System.out.println("            |_|                       ");

        System.out.println("\n\n_____________________________________________________________\n\n");

        System.out.println("\t[1] Customer Reports");
        System.out.println("\t[2] Item Reports");
        System.out.println("\t[3] Orders Reports");

        System.out.print("Enter Option");
        int Optionreports = input.nextInt();

        switch (Optionreports) {
            case 1:
                clearConsole();
                CustomerReports();
                break;
            case 2:
                clearConsole();
                ItemReports();
                break;
            case 3:
                clearConsole();
                OrdersReports();
                break;
            default:
                clearConsole();
                viewreports();
                break;
        }

    }

    public static void CustomerReports() {
        Scanner input = new Scanner(System.in);

        System.out.println("   _____          _                              _____                       _       ");
        System.out.println("  / ____|        | |                            |  __ \\                     | |      ");
        System.out.println(" | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out
                .println(" | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out
                .println(" | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println(
                "  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("                                                           | |                       ");
        System.out.println("                                                           |_|                       ");

        System.out.println("\n\n_____________________________________________________________________________\n\n");

        System.out.println("\t[1] Best in Customers");
        System.out.println("\t[2] view Customers");
        System.out.println("\t[3] All Customer Report");

        System.out.print("Enter Option");
        int OptionCusReports = input.nextInt();

        switch (OptionCusReports) {
            case 1:
                clearConsole();
                BestCustomer();
                break;
            case 2:
                clearConsole();
                ViewCustomer();
                break;
            case 3:
                clearConsole();
                AllCustomer();
                break;
            default:
                clearConsole();
                CustomerReports();
                break;
        }
    }

    public static void BestCustomer() {

        System.out.println("  ____            _     _____          _____          _                                ");
        System.out.println(" |  _ \\          | |   |_   _|        / ____|        | |                               ");
        System.out.println(" | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
        System.out.println( " |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
        System.out.println(
                " | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
        System.out.println(
                " |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");

        System.out.println(
                "\n\n____________________________________________________________________________________________\n\n");
        array2D();

    }

    public static void array2D() {
        CustomerReport[] cusReportar = new CustomerReport[CusArray.length];
        boolean[] processed = new boolean[CusArray.length];
        int validCount = 0;

        for (int i = 0; i < CusArray.length; i++) {
            if (processed[i]) {
                continue;
            }
            cusReportar[validCount] = new CustomerReport();
            int tempqty = CusArray[i].getqty();
            double tempamount = CusArray[i].getamount();
            processed[i] = true;
            

            for (int j = i + 1; j < CusArray.length; j++) {
                
                if (CusArray[i].getContactnum().equals(CusArray[j].getContactnum())) {
                    tempqty = tempqty + CusArray[j].getqty();
                    tempamount += CusArray[j].getamount();
                    processed[j] = true;
                }
            }

            cusReportar[validCount].setValues(CusArray[i].getContactnum(),tempqty,tempamount);

            validCount++;
        }

        for (int i = validCount - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (cusReportar[j].getamount() < cusReportar[j+1].getamount()) {
                    CustomerReport temp = cusReportar[j];
                    cusReportar[j] = cusReportar[j + 1];
                    cusReportar[j + 1] = temp;
                }
            }
        }

        System.out.println("\t\t+--------------------+--------------+-------------------+");
        System.out.println("\t\t|    Customer ID     |      QTY     |     Amount        |");
        System.out.println("\t\t+--------------------+--------------+-------------------+");

        for (int i = 0; i < validCount; i++) {
            System.out.printf("\t\t| %19s|%14d|%19f|\n",cusReportar[i].getContactnum(), cusReportar[i].getqty(),
            cusReportar[i].getamount());
            System.out.printf("\t\t| %19s|%14s|%19s|\n", "", "", "");
        }

        System.out.println("\t\t+--------------------+--------------+-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        Scanner input = new Scanner(System.in);
        int main = input.nextInt();
        if (main == 0) {
            clearConsole();
            main(null);
        } else {
            clearConsole();
            BestCustomer();
        }

    }

    public static void ViewCustomer() {
        System.out.println(" __      ___                  _____          _                                ");
        System.out.println(" \\ \\    / (_)                / ____|        | |                               ");
        System.out.println("  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
        System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
        System.out.println("    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
        System.out.println("     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");

        System.out
                .println("\n\n__________________________________________________________________________________\n\n");

        Scanner input = new Scanner(System.in);
        CustomerReport[] viewReportar = new CustomerReport[CusArray.length];
        boolean[] processed = new boolean[CusArray.length];
        int validCount = 0;

        for (int i = 0; i < CusArray.length; i++) {
            if (processed[i]) {
                continue;
            }

            viewReportar[validCount] = new CustomerReport();
            int tempqty = CusArray[i].getqty();
            double tempamount = CusArray[i].getamount();
            processed[i] = true;

            for (int j = i + 1; j < CusArray.length; j++) {
                if (CusArray[i].getContactnum().equals(CusArray[j].getContactnum())) {
                    tempqty += CusArray[j].getqty();
                    tempamount += CusArray[j].getamount();
                    processed[j] = true;
                }
            }

            viewReportar[validCount].setValues(CusArray[i].getContactnum(),tempqty,tempamount);

            validCount++;
        }

        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------",
                "-------------------+");
        System.out.printf("\t\t|%15s %8s %14s\n", "     Customer ID    |", "     QTY     |",
                "    Amount        |");
        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------",
                "-------------------+");

        for (int i = 0; i < validCount; i++) {
             
            System.out.printf("\t\t| %19s|%14d|%19f|\n",viewReportar[i].getContactnum(), viewReportar[i].getqty(),
            viewReportar[i].getamount());
                System.out.printf("\t\t| %15s    |%8s      |  %14s   |\n", "", "", "");
            

        }
        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------",
                "-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        int main = input.nextInt();
        if (main == 0) {
            clearConsole();
            main(null);
        } else {
            clearConsole();
            ViewCustomer();
        }
    }

    public static void AllCustomer() {
        System.out.println(
                "           _ _    _____          _                              _____                       _   ");
        System.out.println(
                "     /\\   | | |  / ____|        | |                            |  __ \\                     | |  ");
        System.out.println(
                "    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ");
        System.out.println(
                "   / /\\ \\ | | | | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __|");
        System.out.println(
                "  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ ");
        System.out.println(
                " /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|");
        System.out.println(
                "                                                                          | |                   ");
        System.out.println(
                "                                                                          |_|                   ");

        System.out.println();

        System.out.println(
                "____________________________________________________________________________________________________________\n");

        allcustomer[] allCus = new allcustomer[CusArray.length];
        boolean[] processed = new boolean[CusArray.length];
        int validCount = 0;

        for (int i = 0; i < CusArray.length; i++) {
            if (processed[i]) {
                continue;
            }

            allCus[validCount] = new allcustomer();
            int Mcount = 0;
            int XScount = 0;
            int Scount = 0;
            int Lcount = 0;
            int XLcount = 0;
            int XXLcount = 0;

            if (CusArray[i].getTshirtsize().equals("M")) {
                Mcount =CusArray[i].getqty();

            } else if (CusArray[i].getTshirtsize().equals("XS")) {
                XScount = CusArray[i].getqty();

            } else if (CusArray[i].getTshirtsize().equals("S")) {
                Scount = CusArray[i].getqty();

            } else if (CusArray[i].getTshirtsize().equals("L")) {
                Lcount = CusArray[i].getqty();

            } else if (CusArray[i].getTshirtsize().equals("XL")) {
                XLcount = CusArray[i].getqty();

            } else if (CusArray[i].getTshirtsize().equals("XXL")) {
                XXLcount = CusArray[i].getqty();

            }

            double tempamount = CusArray[i].getamount();
            processed[i] = true;

            for (int j = i + 1; j < CusArray.length; j++) {
                if (CusArray[i].getContactnum().equals(CusArray[j].getContactnum())) {

                    if (CusArray[j].getTshirtsize().equals("M")) {
                        Mcount += CusArray[j].getqty();

                    } else if (CusArray[j].getTshirtsize().equals("XS")) {
                        XScount += CusArray[j].getqty();

                    } else if (CusArray[j].getTshirtsize().equals("S")) {
                        Scount += CusArray[j].getqty();

                    } else if (CusArray[j].getTshirtsize().equals("L")) {
                        Lcount += CusArray[j].getqty();

                    } else if (CusArray[j].getTshirtsize().equals("XL")) {
                        XLcount += CusArray[j].getqty();

                    } else if (CusArray[j].getTshirtsize().equals("XXL")) {
                        tempXXLcount += CusArray[j].getqty();
                    }
                    tempamount += CusArray[j].getamount();
                    processed[j] = true;
                }
            }

           allCus[validCount].setValues(CusArray[i].getContactnum(), XScount, Scount, Mcount, Lcount, XLcount, XXLcount, tempamount);
           validCount++;

        }

        // for (int i = 0; i < tshize2Darr.length; i++) {
        // System.out.println(Arrays.toString(tshize2Darr[i]));
        // }

        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%5s+%5s+%12s \n", "+-------------------------", "--------",
                "--------", "--------", "--------", "--------", "--------", "---------------+");
        System.out.printf("\t\t|%10s %5s %5s %5s %5s %5s %5s %12s\n", "      Phone Number       |", " XS    |",
                "   S   |", "    M  |", "    L  |", "   XL  |", "   XXL |", "     Total    |");
        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%5s+%5s+%12s \n", "+-------------------------", "--------",
                "--------", "--------", "--------", "--------", "--------", "---------------+");
        ;

        for (int i = 0; i < validCount; i++) {
            
                System.out.printf("\t\t|%10s               |%5d   |%5d   |%5d   |%5d   |%5d   |%5d   |%12f   | \n",allCus[i].getContactnum(), allCus[i].getXS(), allCus[i].getS(), allCus[i].getM(), allCus[i].getL(),allCus[i].getXL(), allCus[i].getXXL(), allCus[i].getamount());
                System.out.printf("\t\t|%10s               |%5s   |%5s   |%5s   |%5s   |%5s   |%5s   |%12s   | \n",
                        "", "", "", "", "", "", "", "");
            

        }
        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%5s+%5s+%12s \n", "+-------------------------", "--------",
                "--------", "--------", "--------", "--------", "--------", "----------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        Scanner input = new Scanner(System.in);
        int main = input.nextInt();
        if (main == 0) {
            clearConsole();
            main(null);
        } else {
            clearConsole();
            AllCustomer();
        }
    }

    public static void ItemReports() {
        System.out.println("  _____ _                   _____                       _       ");
        System.out.println(" |_   _| |                 |  __ \\                     | |      ");
        System.out.println("   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println("   | | | __/ _ \\ '_ ` _ \\  |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println("  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println(" |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("                                      | |                       ");
        System.out.println("                                      |_|                       ");

        Scanner input = new Scanner(System.in);
        System.out.println("\t[1] Best Selling Categories sorted by Qty");
        System.out.println("\t[2] Best Selling Categories Sorted by amount");
        System.out.println();
        System.out.print("Enter option :");
        int option = input.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                sortqty();
                break;
            case 2:
                clearConsole();
                sortamount();
                break;

            default:
                clearConsole();
                // ItemReports();
                break;
        }

    }

    public static void sortqty() {
        System.out.println("   _____            _           _   ____           ____  _         ");
        System.out.println("  / ____|          | |         | | |  _ \\         / __ \\| |        ");
        System.out.println(" | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | |_ _   _ ");
        System.out.println("  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | | | |  | | __| | | |");
        System.out.println("  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | |_| |_| |");
        System.out.println(" |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\\\__|\\__, |");
        System.out.println("                                           __/ |              __/ |");
        System.out.println("                                          |___/              |___/ ");

        System.out.println("\n\n________________________________________________________________________\n\n");

        System.out.println();
        sort[] sortqty = new sort[6];
        boolean[] processed = new boolean[CusArray.length];



        int Mqty=0;
        int XSqty=0;
        int Sqty=0;
        int Lqty=0;
        int XLqty=0;
        int XXLqty=0;

        double Mtotal=0;
        double XStotal=0;
        double Stotal=0;
        double Ltotal=0;
        double XLtotal=0;
        double XXLtotal=0;

        for (int i = 0; i < CusArray.length; i++) {

            if (CusArray[i].getTshirtsize().equals("M")) {
                Mqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("XL")) {
                XLqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("XS")) {
                XSqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("S")) {
                Sqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("XXL")) {
                XXLqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("L")) {
                Lqty += CusArray[i].getqty();
                
            }

        }
        Mtotal = Mqty * 900;
        XLtotal = XLqty * 1100;
        XStotal = XSqty * 600;
        Stotal = Sqty * 900;
        Ltotal = Lqty * 1000;
        XXLtotal = XXLqty * 1200;

        sortqty[0] =new sort();
        sortqty[0].setValues("XS", XSqty, XStotal);
        sortqty[1] =new sort();
        sortqty[1].setValues("S", Sqty, Stotal);
        sortqty[2] =new sort();
        sortqty[2].setValues("M", Mqty, Mtotal);
        sortqty[3] =new sort();
        sortqty[3].setValues("L", Lqty, Ltotal);
        sortqty[4] =new sort();
        sortqty[4].setValues("XL", XLqty, XLtotal);
        sortqty[5] =new sort();
        sortqty[5].setValues("XXL", XXLqty, XXLtotal);

    //     // for (int i = 0; i < qty2Darr.length; i++) {
    //     // System.out.println(Arrays.toString(qty2Darr[i]));
    //     // }

        for (int i = 5; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (sortqty[j].getqty() < sortqty[j+1].getqty()) {
                    sort temp = sortqty[j];
                    sortqty[j] = sortqty[j+1];
                    sortqty[j+1] = temp;
                }
            }
        }

        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");
        System.out.printf("\t\t|%15s %8s %14s\n", "      Size          |", "     QTY     |", "    Amount        |");
        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        for (int i = 0; i < sortqty.length; i++) {
            System.out.printf("\t\t| %15s    | %8s     |  %14s   |\n",sortqty[i].getSize(), sortqty[i].getqty(),
            sortqty[i].getamount());
            System.out.printf("\t\t| %15s    |%8s      |  %14s   |\n", "", "", "");

        }
        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        Scanner input = new Scanner(System.in);
        int main = input.nextInt();
        if (main == 0) {
            clearConsole();
            main(null);
        } else {
            clearConsole();
            sortqty();
        }

    }

    public static void sortamount() {
        System.out
                .println("   _____            _           _   ____                                               _   ");
        System.out.println(
                "  / ____|          | |         | | |  _ \\            /\\                               | |  ");
        System.out.println(
                " | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
        System.out.println(
                "  \\___ \\ / _ \\| '__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
        System.out.println(
                "  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
        System.out.println(
                " |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
        System.out
                .println("                                           __/ |                                           ");
        System.out
                .println("                                          |___/                                            ");

        System.out.println(
                "\n\n_____________________________________________________________________________________________\n\n");

        System.out.println();
        Scanner input = new Scanner(System.in);
        sort[] sortamount = new sort[6];
        boolean[] processed = new boolean[CusArray.length];



        int Mqty=0;
        int XSqty=0;
        int Sqty=0;
        int Lqty=0;
        int XLqty=0;
        int XXLqty=0;

        double Mtotal=0;
        double XStotal=0;
        double Stotal=0;
        double Ltotal=0;
        double XLtotal=0;
        double XXLtotal=0;

        for (int i = 0; i < CusArray.length; i++) {

            if (CusArray[i].getTshirtsize().equals("M")) {
                Mqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("XL")) {
                XLqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("XS")) {
                XSqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("S")) {
                Sqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("XXL")) {
                XXLqty += CusArray[i].getqty();
                

            } else if (CusArray[i].getTshirtsize().equals("L")) {
                Lqty += CusArray[i].getqty();
                
            }

        }
        Mtotal = Mqty * 900;
        XLtotal = XLqty * 1100;
        XStotal = XSqty * 600;
        Stotal = Sqty * 900;
        Ltotal = Lqty * 1000;
        XXLtotal = XXLqty * 1200;

        sortamount[0] =new sort();
        sortamount[0].setValues("XS", XSqty, XStotal);
        sortamount[1] =new sort();
        sortamount[1].setValues("S", Sqty, Stotal);
        sortamount[2] =new sort();
        sortamount[2].setValues("M", Mqty, Mtotal);
        sortamount[3] =new sort();
        sortamount[3].setValues("L", Lqty, Ltotal);
        sortamount[4] =new sort();
        sortamount[4].setValues("XL", XLqty, XLtotal);
        sortamount[5] =new sort();
        sortamount[5].setValues("XXL", XXLqty, XXLtotal);
        for (int i = 5; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (sortamount[j].getamount() < sortamount[j+1].getamount()) {
                    sort temp = sortamount[j];
                    sortamount[j] = sortamount[j+1];
                    sortamount[j+1] = temp;
                }
            }
        }

        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");
        System.out.printf("\t\t\t|%15s %8s %14s\n", "      Size          |", "     QTY     |", "    Amount        |");
        System.out.printf("\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        for (int i = 0; i < sortamount.length; i++) {
            System.out.printf("\t\t| %15s    | %8d     |  %14.2f   |\n", sortamount[i].getSize(), sortamount[i].getqty(),
            sortamount[i].getamount());
            System.out.printf("\t\t| %15s    |%8s      |  %14s   |\n", "", "", "");
        }
        System.out.printf("\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        int main = input.nextInt();
        if (main == 0) {
            clearConsole();
            main(null);
        } else {
            clearConsole();
            sortamount();
        }
    }

    public static void OrdersReports() {
        System.out.println("   ____          _             _____                       _       ");
        System.out.println("  / __ \\        | |           |  __ \\                     | |      ");
        System.out.println(" | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ ");
        System.out.println(" | |  | | '__/ _` |/ _ \\ '__| |  _  // _ \\ '_ \\ / _ \\| '__| __/ __|");
        System.out.println(" | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\");
        System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/");
        System.out.println("                                         | |                       ");
        System.out.println("                                         |_|                       ");

        System.out.println();
        System.out.println("\t[1] All Orders ");
        System.out.println("\t[2] Orders By Amount\n");
        System.out.println();
        System.out.print("Enter option:");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                allorders();
                break;
            case 2:
                clearConsole();
                ordersamount();
                break;
            default:
                clearConsole();
                OrdersReports();
                break;
        }
    }

    public static void allorders() {
        System.out.println(" __      ___                  ____          _               ");
        System.out.println(" \\ \\    / (_)                / __ \\        | |              ");
        System.out.println("  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ ");
        System.out.println("   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | '__/ _` |/ _ \\ '__/ __|");
        System.out.println("    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\");
        System.out.println("     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/");

        System.out.println("________________________________________________________________________");

        System.out.println();
        Scanner input = new Scanner(System.in);

        String[] statuStringar = new String[CusArray.length];

        for (int i = 0; i < statuStringar.length; i++) {
            if (CusArray[i].getstatus() == 0) {
                statuStringar[i] = "Processing";
            } else if (CusArray[i].getstatus() == 1) {
                statuStringar[i] = "Delivering";
            } else if (CusArray[i].getstatus() == 2) {
                statuStringar[i] = "Delivered";
            }
        }

        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%6s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");
        System.out.printf("\t\t|%10s %5s %5s %5s %5s %6s\n", "      Order ID   |", "Customer ID |", " size  |",
                "  Qty  |", " Amount  |", " Status  |");
        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%6s \n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        for (int i = CusArray.length - 1; i >= 0; i--) {

            System.out.printf("\t\t|%10s       |%5s   |%5s   |%5d   |%5.2f   |%6s|\n",
                    CusArray[i].getOrdeId(), CusArray[i].getContactnum(), CusArray[i].getTshirtsize(),CusArray[i].getqty(), CusArray[i].getamount(), statuStringar[i]);
            System.out.printf("\t\t|%10s       |%5s        |%5s   |%5s   |%5s     |%10s|\n", "", "", "", "", "",
                    "", "", "");

        }
        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%5s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        System.out.println();

        System.out.print("To access the Main Menu,Please enter 0 :");

        int main = input.nextInt();
        if (main == 0) {
            clearConsole();
            main(null);
        } else {
            clearConsole();
            allorders();
        }
    }

    public static void ordersamount() {
        System.out.println("   ____          _                 ____                                               _   ");
        System.out.println("  / __ \\        | |               |  _ \\            /\\                               | |  ");
        System.out
                .println(" | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ ");
        System.out.println(
                " | |  | | '__/ _` |/ _ \\ '__/ __| |  _ <| | | |   / /\\ \\ | '_ ` _ \\ / _ \\| | | | '_ \\| __|");
        System.out.println(
                " | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ ");
        System.out.println(
                "  \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|");
        System.out
                .println("                                          __/ |                                           ");
        System.out
                .println("                                         |___/                                            ");

        System.out.println();
        Scanner input = new Scanner(System.in);
        Customer[] odramount = new Customer[CusArray.length];
        String[] statuStringar = new String[CusArray.length];

        for (int i = 0; i < statuStringar.length; i++) {
            if (CusArray[i].getstatus() == 0) {
                statuStringar[i] = "Processing";
            } else if (CusArray[i].getstatus() == 1) {
                statuStringar[i] = "Delivering";
            } else if (CusArray[i].getstatus() == 2) {
                statuStringar[i] = "Delivered";
            }
        }

        for (int i = 0; i < CusArray.length; i++) {
            // copy previous data
            odramount[i] = CusArray[i];
        }

        for (int i = CusArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (odramount[j].getamount() < odramount[j + 1].getamount()) {
                    Customer temp = odramount[j];
                    odramount[j] = odramount[j + 1];
                    odramount[j + 1] = temp;
                }
            }
        }

        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%10s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");
        System.out.printf("\t\t|%10s %5s %5s %5s %5s %10s\n", "      Order ID   |", "Customer ID |", " size  |",
                "  Qty  |", " Amount  |", " Status  |");
        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%10s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        for (int i = 0; i < odramount.length; i++) {

            System.out.printf("\t\t|%10s       |%5s   |%5s   |%5d   |%10.2f|%10s|\n", odramount[i].getOrdeId(),
            odramount[i].getContactnum(), odramount[i].getTshirtsize(), odramount[i].getqty(), odramount[i].getamount(), statuStringar[i]);
            System.out.printf("\t\t|%10s       |%5s        |%5s   |%5s   |%5s     |%10s|\n", "", "", "", "", "",
                    "", "", "");

        }
        System.out.printf("\t\t%10s+%5s+%5s+%5s+%5s+%10s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        System.out.println();

        System.out.print("To access the Main Menu,Please enter 0 :");

        int main = input.nextInt();
        if (main == 0) {
            clearConsole();
            main(null);
        } else {
            clearConsole();
            ordersamount();
        }

    }

    public static void setorder() {

        System.out.println("   ____          _              _____ _        _             ");
        System.out.println("  / __ \\        | |            / ____| |      | |            ");
        System.out.println(" | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ ");
        System.out.println(" | |  | | '__/ _` |/ _ \\ '__|  \\___ \\| __/ _` | __| | | / __|");
        System.out.println(" | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\");
        System.out.println("  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/");

        System.out.println();

        Scanner input = new Scanner(System.in);
        System.out.print("Enter order ID:");
        String odrID = input.nextLine();
        boolean isfound = false;

        for (int i = 0; i < CusArray.length; i++) {
            if (odrID.equals(CusArray[i].getOrdeId())) {
                isfound = true;
                System.out.println("Phone Number :" + CusArray[i].getContactnum());
                System.out.println("Size         :" + CusArray[i].getTshirtsize());
                System.out.println("QTY          :" + CusArray[i].getqty());
                System.out.println("Amount       :" + CusArray[i].getamount());
                if (CusArray[i].getstatus() == 0) {
                    System.out.println("Status       : processing");
                } else if (CusArray[i].getstatus() == 1) {
                    System.out.println("Status       : Delivering");
                } else if (CusArray[i].getstatus() == 2) {
                    System.out.println("Status       : Delivered");
                }

                System.out.println();

                switch (CusArray[i].getstatus()) {
                    case 0:

                        System.out.print("Do you want to change this order status? (y/n) :");
                        char yesno = input.next().charAt(0);

                        if (yesno == 'y' || yesno == 'Y') {
                            System.out.println("\n\t[1] Order Delivering");
                            System.out.println("\t[2] Order Delivered");
                            System.out.println();
                            System.out.print("\nEnter option :");
                            int option = input.nextInt();

                            switch (option) {
                                case 1:
                                CusArray[i].setstatus(Delivering);
                                    System.out.println("Status Updated");
                                    break;

                                case 2:
                                CusArray[i].setstatus(Delivered);
                                    System.out.println("Status Updated");
                                    break;

                                default:
                                    break;
                            }

                        } else if (yesno == 'N' || yesno == 'n') {
                            clearConsole();
                            main(null);

                        }
                        break;

                    case 1:

                        System.out.print("Do you want to change this order status? (y/n) :");
                        char yesno1 = input.next().charAt(0);

                        if (yesno1 == 'y' || yesno1 == 'Y') {
                            System.out.println("\n\t[1] Order Delivered");

                            System.out.print("\nEnter option :");
                            int option = input.nextInt();

                            switch (option) {
                                case 1:
                                CusArray[i].setstatus(Delivered);
                                    System.out.println("Status Updated");
                                    break;

                                default:
                                    break;
                            }

                        } else if (yesno1 == 'N' || yesno1 == 'n') {
                            clearConsole();
                            main(null);

                        }
                        break;

                    case 2:
                        System.out.println("Can't change this order status,Order already delivered..!");

                    default:
                        break;
                }
                System.out.println();
                System.out.print("Do you want to change another order status? (y/n) :");
                char yesno = input.next().charAt(0);

                if (yesno == 'y' || yesno == 'Y') {
                    clearConsole();
                    setorder();
                } else if (yesno == 'N' || yesno == 'n') {
                    clearConsole();
                    main(null);
                }

            }
        }

    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
}

