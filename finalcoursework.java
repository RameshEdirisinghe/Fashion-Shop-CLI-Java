import java.util.*;

class finalcoursework {
    static String[] idarray = new String[0];
    static String[] contactnumber = new String[0];
    static int[] qtyarray = new int[0];
    static double[] amountarray = new double[0];
    static String[] tshirtsizearray = new String[0];

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
                setorder();
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
        String[] tempidarray = new String[idarray.length + 1]; // increment array length
        String[] tempcontact = new String[contactnumber.length + 1];
        int[] tempqty = new int[qtyarray.length + 1];
        double[] tempamountarray = new double[amountarray.length + 1];
        String[] temptshirtsizearray = new String[tshirtsizearray.length + 1];

        for (int i = 0; i < idarray.length; i++) {
            // copy previous data
            tempidarray[i] = idarray[i];
            tempcontact[i] = contactnumber[i];
            tempamountarray[i] = amountarray[i];
            temptshirtsizearray[i] = tshirtsizearray[i];
            tempqty[i] = qtyarray[i];
        }

        tempidarray[tempidarray.length - 1] = newOrderID; // Assign the new value to the last index
        idarray = tempidarray;// change array address

        tempcontact[tempcontact.length - 1] = contact;
        contactnumber = tempcontact;

        tempqty[tempqty.length - 1] = QTY;
        qtyarray = tempqty;

        tempamountarray[tempamountarray.length - 1] = amount;
        amountarray = tempamountarray;

        temptshirtsizearray[temptshirtsizearray.length - 1] = tshirtsize;
        tshirtsizearray = temptshirtsizearray;

        // System.out.println(Arrays.toString(contactnumber));
        // System.out.println(Arrays.toString(idarray));
        // System.out.println(Arrays.toString(tshirtsizearray));
        // System.out.println(Arrays.toString(amountarray));
        // System.out.println(Arrays.toString(qtyarray));
        // System.out.println("order placed");
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
        boolean iscorrect = false;
        for (int i = 0; i < contactnumber.length; i++) {

            if (numberid.equals(contactnumber[i])) {
                iscorrect = true;
                if (tshirtsizearray[i].equals("M")) {
                    tempMcount += qtyarray[i];
                } else if (tshirtsizearray[i].equals("XS")) {
                    tempXScount += qtyarray[i];
                } else if (tshirtsizearray[i].equals("S")) {
                    tempScount += qtyarray[i];
                } else if (tshirtsizearray[i].equals("L")) {
                    tempLcount += qtyarray[i];
                } else if (tshirtsizearray[i].equals("XL")) {
                    tempXLcount += qtyarray[i];
                } else if (tshirtsizearray[i].equals("XXL")) {
                    tempXXLcount += qtyarray[i];
                }

            }

        }
        if (iscorrect == false) {
            System.out.println("Invalid Input...");
            System.out.println("Do you want to enter phone number again? (y/n) :");
            char yesno = input.next().charAt(QTY);

            if (yesno == 'y' || yesno == 'Y') {
                clearConsole();
                SearchCustomer();
            } else if (yesno == 'N' || yesno == 'n') {
                clearConsole();
                main(null);
            }
        }

        printresult();

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
        for (int i = 0; i < idarray.length; i++) {

            if (searchoid.equals(idarray[i])) {
                System.out.println("\nPhone number :" + contactnumber[i]);
                System.out.println("Size         :" + tshirtsizearray[i]);
                System.out.println("QTY          :" + qtyarray[i]);
                System.out.println("Amount       :" + amountarray[i]);
                if (Status == 0) {
                    System.out.println("Status       : Processing");
                } else if (Status == 1) {
                    System.out.println("Status       : Delivering");
                } else if (Status == 2) {
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

        for (int i = 0; i < idarray.length; i++) {

            if (searchoid.equals(idarray[i])) {

                System.out.println("\nPhone number :" + contactnumber[i]);
                System.out.println("Size         :" + tshirtsizearray[i]);
                System.out.println("QTY          :" + qtyarray[i]);
                System.out.println("Amount       :" + amountarray[i]);
                if (Status == 0) {
                    System.out.println("Status       : Processing");
                } else if (Status == 1) {
                    System.out.println("Status       : Delivering");
                } else if (Status == 2) {
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

        // check
        // System.out.println(Arrays.toString(contactnumber));
        // System.out.println(Arrays.toString(idarray));
        // System.out.println(Arrays.toString(tshirtsizearray));
        // System.out.println(Arrays.toString(qtyarray));
        // System.out.println(Arrays.toString(amountarray));

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

        String[] tempidarray = new String[idarray.length - 1];
        String[] tempcontact = new String[contactnumber.length - 1];
        int[] tempqty = new int[qtyarray.length - 1];
        double[] tempamountarray = new double[amountarray.length - 1];
        String[] temptshirtsizearray = new String[tshirtsizearray.length - 1];

        for (int i = 0, j = 0; i < idarray.length; i++) {

            if (i != deleteindex) {
                tempidarray[j] = idarray[i];
                tempcontact[j] = contactnumber[i];
                tempamountarray[j] = amountarray[i];
                temptshirtsizearray[j] = tshirtsizearray[i];
                tempqty[j] = qtyarray[i];
                j++;
            }
        }

        idarray = tempidarray;
        contactnumber = tempcontact;
        amountarray = tempamountarray;
        tshirtsizearray = temptshirtsizearray;
        qtyarray = tempqty;

        // System.out.println(Arrays.toString(contactnumber));
        // System.out.println(Arrays.toString(idarray));
        // System.out.println(Arrays.toString(tshirtsizearray));
        // System.out.println(Arrays.toString(qtyarray));
        // System.out.println(Arrays.toString(amountarray));

    }

    public static void setorder() {

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
                CustomerReports();
                break;
            case 2:
                ItemReports();
                break;
            case 3:
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
                BestCustomer();
                break;
            case 2:
                ViewCustomer();
                break;
            case 3:
                AllCustomer();
                break;
            default:
                clearConsole();
                CustomerReports();
                break;
        }
    }

    public static void BestCustomer() {
        array2D();
    }

    public static void array2D() {

        String[][] amount2Darr = new String[contactnumber.length][3];
        boolean[] processed = new boolean[contactnumber.length];

        for (int i = 0; i < contactnumber.length; i++) {
            if (processed[i]) {
                continue;
            }

            int tempqty = qtyarray[i];
            double tempamount = amountarray[i];
            processed[i] = true;

            for (int j = i + 1; j < contactnumber.length; j++) {
                if (contactnumber[i].equals(contactnumber[j])) {
                    tempqty += qtyarray[j];
                    tempamount += amountarray[j];
                    processed[j] = true;
                }
            }

            amount2Darr[i][0] = contactnumber[i];
            amount2Darr[i][1] = String.valueOf(tempqty);
            amount2Darr[i][2] = String.valueOf(tempamount);
        }

        int[][] intArray = new int[stringArray.length][stringArray[0].length];
        for (int i = 0; i < stringArray.length; i++) {
            for (int j = 0; j < stringArray[i].length; j++) {
                intArray[i][j] = Integer.parseInt(stringArray[i][j]);
            }
        }

        // for (int i = amount2Darr.length - 1; i > 0; i--) {
        //     for (int j = 0; j < i; j++) {
        //         if (processed[j]) {
        //             continue;  // Skip the already processed rows
        //         }
                
        //         // Compare based on the third column (converted to integer)
        //         if (Integer.parseInt(amount2Darr[j][2]) > Integer.parseInt(amount2Darr[j + 1][2])) {
        //             // Swap the entire row
        //             String[] temp = amount2Darr[j];
        //             amount2Darr[j] = amount2Darr[j + 1];
        //             amount2Darr[j + 1] = temp;
        //         }
        //     }
        // }

        System.out.println(Arrays.toString(amount2Darr[0]));
        System.out.println(Arrays.toString(amount2Darr[1]));
        System.out.println(Arrays.toString(amount2Darr[2]));
        System.out.println(Arrays.toString(amount2Darr[3]));
        System.out.println(Arrays.toString(amount2Darr[4]));

    }

    public static void ViewCustomer() {

    }

    public static void AllCustomer() {

    }

    public static void ItemReports() {

    }

    public static void OrdersReports() {

    }

    public static void sizeoftshirt() {
        // String[][] customerDetails = new String[phoneNumberArray.length][3];

        // for (int i = 0; i < phoneNumberArray.length; i++) {

        //     for (int j = 0; j < i; j++) {

        //         if (phoneNumberArray[i] == customerDetails[j][0]) {

        //         }
        //     }

        //     customerDetails[i][0] = phoneNumberArray[i];
        //     customerDetails[i][1] = String.valueOf(qtyArray[i]);
        //     customerDetails[i][2] = String.valueOf(amountArray[i]);
        // }
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
