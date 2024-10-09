import java.util.*;

class finalcoursework {
    static String[] idarray = new String[0];
    static String[] contactnumber = new String[0];
    static int[] qtyarray = new int[0];
    static double[] amountarray = new double[0];
    static String[] tshirtsizearray = new String[0];
    static int[] Statusar = new int[0];

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
        int[] tempStatusar = new int[Statusar.length + 1];

        for (int i = 0; i < idarray.length; i++) {
            // copy previous data
            tempidarray[i] = idarray[i];
            tempcontact[i] = contactnumber[i];
            tempamountarray[i] = amountarray[i];
            temptshirtsizearray[i] = tshirtsizearray[i];
            tempqty[i] = qtyarray[i];
            tempStatusar[i] = Statusar[i];
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

        tempStatusar[tempStatusar.length - 1] = Status;
        Statusar = tempStatusar;

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

        System.out.println("  ____            _     _____          _____          _                                ");
        System.out.println(" |  _ \\          | |   |_   _|        / ____|        | |                               ");
        System.out.println(" | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ ");
        System.out.println(
                " |  _ < / _ \\/ __| __|   | | | '_ \\  | |   | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__/ __|");
        System.out.println(
                " | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\");
        System.out.println(
                " |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/");

        System.out.println(
                "\n\n____________________________________________________________________________________________\n\n");
        array2D();

    }

    public static void array2D() {
        String[][] amount2Darr = new String[contactnumber.length][3];
        boolean[] processed = new boolean[contactnumber.length];

        int validCount = 0;

        for (int i = 0; i < contactnumber.length; i++) {
            if (processed[i]) {
                continue;
            }

            int tempqty = qtyarray[i];
            double tempamount = amountarray[i];
            processed[i] = true;

            for (int j = i + 1; j < contactnumber.length; j++) {
                if (contactnumber[i].equals(contactnumber[j])) {
                    tempqty = tempqty + qtyarray[j];
                    tempamount += amountarray[j];
                    processed[j] = true;
                }
            }

            amount2Darr[validCount][0] = contactnumber[i];
            amount2Darr[validCount][1] = String.valueOf(tempqty);
            amount2Darr[validCount][2] = String.valueOf(tempamount);
            validCount++;
        }

        for (int i = validCount - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (Double.parseDouble(amount2Darr[j][2]) < Double.parseDouble(amount2Darr[j + 1][2])) {
                    String[] temp = amount2Darr[j];
                    amount2Darr[j] = amount2Darr[j + 1];
                    amount2Darr[j + 1] = temp;
                }
            }
        }

        System.out.println("+--------------------+--------------+-------------------+");
        System.out.println("|    Customer ID     |      QTY     |     Amount        |");
        System.out.println("+--------------------+--------------+-------------------+");

        for (int i = 0; i < validCount; i++) {
            System.out.printf("\t\t\t\t\t| %15s | %8s | %14s |\n", amount2Darr[i][0], amount2Darr[i][1],
                    amount2Darr[i][2]);
            System.out.printf("\t\t\t\t\t| %15s |%8s | %14s |\n", "", "", "");
        }

        System.out.println("+--------------------+--------------+-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        Scanner input = new Scanner(System.in);
        int main = input.nextInt();
        if (main == 0) {
            main(null);
        } else {
            clearConsole();
            BestCustomer();
        }
        // String[][] amount2Darr = new String[contactnumber.length][3];
        // boolean[] processed = new boolean[contactnumber.length];

        // for (int i = 0; i < contactnumber.length; i++) {
        // if (processed[i]) {
        // continue;
        // }

        // int tempqty = qtyarray[i];
        // double tempamount = amountarray[i];
        // processed[i] = true;

        // for (int j = i + 1; j < contactnumber.length; j++) {
        // if (contactnumber[i].equals(contactnumber[j])) {
        // tempqty += qtyarray[j];
        // tempamount += amountarray[j];
        // processed[j] = true;
        // }
        // }

        // amount2Darr[i][0] = contactnumber[i];
        // amount2Darr[i][1] = String.valueOf(tempqty);
        // amount2Darr[i][2] = String.valueOf(tempamount);
        // }

        // for (int i = 0; i < amount2Darr.length; i++) {
        // System.out.println(Arrays.toString(amount2Darr[i]));
        // }

        // int validCount = 0;

        // for (int i = 0; i < amount2Darr.length; i++) {
        // if (amount2Darr[i] != null && amount2Darr[i][0] != null) {
        // // Move non-null row to the next available slot at the beginning
        // amount2Darr[validCount] = amount2Darr[i];
        // validCount++;
        // }
        // }

        // for (int i = validCount - 1; i > 0; i--) {
        // for (int j = 0; j < i; j++) {

        // if (amount2Darr[j][2] != null && amount2Darr[j + 1][2] != null) {

        // if (Double.parseDouble(amount2Darr[j][2]) < Double.parseDouble(amount2Darr[j
        // + 1][2])) {

        // String[] temp = amount2Darr[j];
        // amount2Darr[j] = amount2Darr[j + 1];
        // amount2Darr[j + 1] = temp;
        // }
        // }

        // }
        // }

        // System.out.printf("\t\t\t\t\t%15s+%8s+%14s\n", "+--------------------",
        // "--------------",
        // "-------------------+");
        // System.out.printf("\t\t\t\t\t|%15s %8s %14s\n", " Size |", " QTY |",
        // " Amount |");
        // System.out.printf("\t\t\t\t\t%15s+%8s+%14s\n", "+--------------------",
        // "--------------",
        // "-------------------+");

        // // System.out.println(Arrays.toString(bestCustomer[4]));

        // for (int i = 0; i < amount2Darr.length; i++) {
        // if (amount2Darr[i][2] != null) {
        // System.out.printf("\t\t\t\t\t| %15s | %8s | %14s |\n", amount2Darr[i][0],
        // amount2Darr[i][1],
        // amount2Darr[i][2]);
        // System.out.printf("\t\t\t\t\t| %15s |%8s | %14s |\n", "", "", "");
        // }

        // }
        // System.out.printf("\t\t\t\t\t%15s+%8s+%14s\n", "+--------------------",
        // "--------------",
        // "-------------------+");

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

        // System.out.println(Arrays.toString(bestCustomer[0]));
        // System.out.println(Arrays.toString(bestCustomer[1]));
        // System.out.println(Arrays.toString(bestCustomer[2]));
        // System.out.println(Arrays.toString(bestCustomer[3]));
        // System.out.println(Arrays.toString(bestCustomer[4]));

        System.out.printf("\t\t\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------",
                "-------------------+");
        System.out.printf("\t\t\t\t\t|%15s %8s %14s\n", "     Customer ID    |", "     QTY     |",
                "    Amount        |");
        System.out.printf("\t\t\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------",
                "-------------------+");

        for (int i = 0; i < amount2Darr.length; i++) {
            if (amount2Darr[i][2] != null) {
                System.out.printf("\t\t\t\t\t| %15s    | %8s     |  %14s   |\n", amount2Darr[i][0], amount2Darr[i][1],
                        amount2Darr[i][2]);
                System.out.printf("\t\t\t\t\t| %15s    |%8s      |  %14s   |\n", "", "", "");
            }

        }
        System.out.printf("\t\t\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------",
                "-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        int main = input.nextInt();
        if (main == 0) {
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
                "____________________________________________________________________________________________________________");

        int[][] tshize2Darr = new int[contactnumber.length][8];
        boolean[] processed = new boolean[contactnumber.length];

        for (int i = 0; i < contactnumber.length; i++) {
            if (processed[i]) {
                continue;
            }

            // tshize2Darr[i][1] = ("0");
            // tshize2Darr[i][2] = ("0");
            // tshize2Darr[i][3] = ("0");
            // tshize2Darr[i][4] = ("0");
            // tshize2Darr[i][5] = ("0");
            // tshize2Darr[i][6] = ("0");

            // recreate count variable for this method
            int Mcount = 0;
            int XScount = 0;
            int Scount = 0;
            int Lcount = 0;
            int XLcount = 0;
            int XXLcount = 0;

            if (tshirtsizearray[i].equals("M")) {
                Mcount = qtyarray[i];
                tshize2Darr[i][3] = Mcount;

            } else if (tshirtsizearray[i].equals("XS")) {
                XScount = qtyarray[i];
                tshize2Darr[i][1] = XScount;

            } else if (tshirtsizearray[i].equals("S")) {
                Scount = qtyarray[i];
                tshize2Darr[i][2] = Scount;

            } else if (tshirtsizearray[i].equals("L")) {
                Lcount = qtyarray[i];
                tshize2Darr[i][4] = Lcount;

            } else if (tshirtsizearray[i].equals("XL")) {
                XLcount = qtyarray[i];
                tshize2Darr[i][5] = XLcount;

            } else if (tshirtsizearray[i].equals("XXL")) {
                XXLcount = qtyarray[i];
                tshize2Darr[i][6] = XXLcount;
            }

            double tempamount = amountarray[i];
            processed[i] = true;

            for (int j = i + 1; j < contactnumber.length; j++) {
                if (contactnumber[i].equals(contactnumber[j])) {

                    if (tshirtsizearray[j].equals("M")) {
                        Mcount += qtyarray[j];
                        tshize2Darr[i][3] = Mcount;

                    } else if (tshirtsizearray[j].equals("XS")) {
                        XScount += qtyarray[j];
                        tshize2Darr[i][1] = XScount;

                    } else if (tshirtsizearray[j].equals("S")) {
                        Scount += qtyarray[j];
                        tshize2Darr[i][2] = Scount;

                    } else if (tshirtsizearray[j].equals("L")) {
                        Lcount += qtyarray[j];
                        tshize2Darr[i][4] = Lcount;

                    } else if (tshirtsizearray[j].equals("XL")) {
                        XLcount += qtyarray[j];
                        tshize2Darr[i][5] = XLcount;

                    } else if (tshirtsizearray[j].equals("XXL")) {
                        tempXXLcount += qtyarray[j];
                        tshize2Darr[i][6] = XXLcount;
                    }
                    tempamount += amountarray[j];
                    processed[j] = true;
                }
            }

            tshize2Darr[i][0] = Integer.parseInt(contactnumber[i]);
            // tshize2Darr[i][1] = String.valueOf(tempXScount);
            // tshize2Darr[i][2] = String.valueOf(tempScount);
            // tshize2Darr[i][3] = String.valueOf(tempMcount);
            // tshize2Darr[i][4] = String.valueOf(tempLcount);
            // tshize2Darr[i][5] = String.valueOf(tempXLcount);
            // tshize2Darr[i][6] = String.valueOf(tempXXLcount);
            tshize2Darr[i][7] = (int) tempamount;

        }

        for (int i = 0; i < tshize2Darr.length; i++) {
            System.out.println(Arrays.toString(tshize2Darr[i]));
        }

        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s+%5s+%12s \n", "+-------------------------", "--------",
                "--------", "--------", "--------", "--------", "--------", "---------------+");
        System.out.printf("\t\t\t\t|%10s %5s %5s %5s %5s %5s %5s %12s\n", "      Phone Number       |", " XS    |",
                "   S   |", "    M  |", "    L  |", "   XL  |", "   XXL |", "     Total    |");
        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s+%5s+%12s \n", "+-------------------------", "--------",
                "--------", "--------", "--------", "--------", "--------", "---------------+");
        ;

        for (int i = 0; i < tshize2Darr.length; i++) {
            if (tshize2Darr[i][0] != 0) {
                System.out.printf("\t\t\t\t|%010d               |%5d   |%5d   |%5d   |%5d   |%5d   |%5d   |%12d   | \n",
                        tshize2Darr[i][0], tshize2Darr[i][1], tshize2Darr[i][2], tshize2Darr[i][3], tshize2Darr[i][4],
                        tshize2Darr[i][5], tshize2Darr[i][6], tshize2Darr[i][7]);
                System.out.printf("\t\t\t\t|%10s               |%5s   |%5s   |%5s   |%5s   |%5s   |%5s   |%12s   | \n",
                        "", "", "", "", "", "", "", "");
            }

        }
        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s+%5s+%12s \n", "+-------------------------", "--------",
                "--------", "--------", "--------", "--------", "--------", "----------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        Scanner input = new Scanner(System.in);
        int main = input.nextInt();
        if (main == 0) {
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

        System.out.print("Enter option :");
        int option = input.nextInt();

        switch (option) {
            case 1:
                sortqty();
                break;
            case 2:
                sortamount();
                break;

            default:
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

        String[][] qty2Darr = new String[6][3];
        boolean[] processed = new boolean[contactnumber.length];
        qty2Darr[0][0] = "M";
        qty2Darr[1][0] = "XL";
        qty2Darr[2][0] = "XS";
        qty2Darr[3][0] = "S";
        qty2Darr[4][0] = "XXL";
        qty2Darr[5][0] = "L";

        int Mqty = 0;
        int XLqty = 0;
        int XSqty = 0;
        int Sqty = 0;
        int XXLqty = 0;
        int Lqty = 0;

        int Mtotal = 0;
        int XLtotal = 0;
        int XStotal = 0;
        int Stotal = 0;
        int XXLtotal = 0;
        int Ltotal = 0;

        qty2Darr[0][1] = "0";
        qty2Darr[1][1] = "0";
        qty2Darr[2][1] = "0";
        qty2Darr[3][1] = "0";
        qty2Darr[4][1] = "0";
        qty2Darr[5][1] = "0";
        // int validCount = 0;

        for (int i = 0; i < contactnumber.length; i++) {
            // if (processed[i]) {
            // continue;
            // }

            if (tshirtsizearray[i].equals("M")) {
                Mqty += qtyarray[i];
                qty2Darr[0][1] = String.valueOf(Mqty);

            } else if (tshirtsizearray[i].equals("XL")) {
                XLqty += qtyarray[i];
                qty2Darr[1][1] = String.valueOf(XLqty);

            } else if (tshirtsizearray[i].equals("XS")) {
                XSqty += qtyarray[i];
                qty2Darr[2][1] = String.valueOf(XSqty);

            } else if (tshirtsizearray[i].equals("S")) {
                Sqty += qtyarray[i];
                qty2Darr[3][1] = String.valueOf(Sqty);

            } else if (tshirtsizearray[i].equals("XXL")) {
                XXLqty += qtyarray[i];
                qty2Darr[4][1] = String.valueOf(XXLqty);

            } else if (tshirtsizearray[i].equals("L")) {
                Lqty += qtyarray[i];
                qty2Darr[5][1] = String.valueOf(Lqty);
            }

            // int tempqty = qtyarray[i];
            // double tempamount = amountarray[i];
            // processed[i] = true;

            // for (int j = i + 1; j < contactnumber.length; j++) {
            // if (contactnumber[i].equals(contactnumber[j])) {
            // tempqty = tempqty + qtyarray[j];
            // tempamount += amountarray[j];
            // processed[j] = true;
            // }
            // }

            // amount2Darr[validCount][0] = contactnumber[i];
            // amount2Darr[validCount][1] = String.valueOf(tempqty);
            // amount2Darr[validCount][2] = String.valueOf(tempamount);
            // validCount++;
        }
        Mtotal = Mqty * 900;
        XLtotal = XLqty * 1100;
        XStotal = XSqty * 600;
        Stotal = Sqty * 900;
        Ltotal = Lqty * 1000;
        XXLtotal = XXLqty * 1200;

        qty2Darr[0][2] = String.valueOf(Mtotal);
        qty2Darr[1][2] = String.valueOf(XLtotal);
        qty2Darr[2][2] = String.valueOf(XStotal);
        qty2Darr[3][2] = String.valueOf(Stotal);
        qty2Darr[4][2] = String.valueOf(XXLtotal);
        qty2Darr[5][2] = String.valueOf(Ltotal);

        for (int i = 0; i < qty2Darr.length; i++) {
            System.out.println(Arrays.toString(qty2Darr[i]));
        }

        for (int i = 5; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(qty2Darr[j][1]) < Integer.parseInt(qty2Darr[j + 1][1])) {
                    String[] temp = qty2Darr[j];
                    qty2Darr[j] = qty2Darr[j + 1];
                    qty2Darr[j + 1] = temp;
                }
            }
        }

        System.out.printf("\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");
        System.out.printf("\t\t\t|%15s %8s %14s\n", "      Size          |", "     QTY     |", "    Amount        |");
        System.out.printf("\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        for (int i = 0; i < qty2Darr.length; i++) {
            System.out.printf("\t\t\t| %15s    | %8s     |  %14s   |\n", qty2Darr[i][0], qty2Darr[i][1],
                    qty2Darr[i][2]);
            System.out.printf("\t\t\t| %15s    |%8s      |  %14s   |\n", "", "", "");

        }
        System.out.printf("\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        Scanner input = new Scanner(System.in);
        int main = input.nextInt();
        if (main == 0) {
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

        Scanner input = new Scanner(System.in);
        String[][] size2Darr = new String[6][3];
        boolean[] processed = new boolean[contactnumber.length];
        size2Darr[0][0] = "M";
        size2Darr[1][0] = "XL";
        size2Darr[2][0] = "XS";
        size2Darr[3][0] = "S";
        size2Darr[4][0] = "XXL";
        size2Darr[5][0] = "L";

        int Mqty = 0;
        int XLqty = 0;
        int XSqty = 0;
        int Sqty = 0;
        int XXLqty = 0;
        int Lqty = 0;

        int Mtotal = 0;
        int XLtotal = 0;
        int XStotal = 0;
        int Stotal = 0;
        int XXLtotal = 0;
        int Ltotal = 0;

        size2Darr[0][1] = "0";
        size2Darr[1][1] = "0";
        size2Darr[2][1] = "0";
        size2Darr[3][1] = "0";
        size2Darr[4][1] = "0";
        size2Darr[5][1] = "0";
        // int validCount = 0;

        for (int i = 0; i < contactnumber.length; i++) {
            // if (processed[i]) {
            // continue;
            // }

            if (tshirtsizearray[i].equals("M")) {
                Mqty += qtyarray[i];
                size2Darr[0][1] = String.valueOf(Mqty);

            } else if (tshirtsizearray[i].equals("XL")) {
                XLqty += qtyarray[i];
                size2Darr[1][1] = String.valueOf(XLqty);

            } else if (tshirtsizearray[i].equals("XS")) {
                XSqty += qtyarray[i];
                size2Darr[2][1] = String.valueOf(XSqty);

            } else if (tshirtsizearray[i].equals("S")) {
                Sqty += qtyarray[i];
                size2Darr[3][1] = String.valueOf(Sqty);

            } else if (tshirtsizearray[i].equals("XXL")) {
                XXLqty += qtyarray[i];
                size2Darr[4][1] = String.valueOf(XXLqty);

            } else if (tshirtsizearray[i].equals("L")) {
                Lqty += qtyarray[i];
                size2Darr[5][1] = String.valueOf(Lqty);
            }

            // int tempqty = qtyarray[i];
            // double tempamount = amountarray[i];
            // processed[i] = true;

            // for (int j = i + 1; j < contactnumber.length; j++) {
            // if (contactnumber[i].equals(contactnumber[j])) {
            // tempqty = tempqty + qtyarray[j];
            // tempamount += amountarray[j];
            // processed[j] = true;
            // }
            // }

            // amount2Darr[validCount][0] = contactnumber[i];
            // amount2Darr[validCount][1] = String.valueOf(tempqty);
            // amount2Darr[validCount][2] = String.valueOf(tempamount);
            // validCount++;
        }
        Mtotal = Mqty * 900;
        XLtotal = XLqty * 1100;
        XStotal = XSqty * 600;
        Stotal = Sqty * 900;
        Ltotal = Lqty * 1000;
        XXLtotal = XXLqty * 1200;

        size2Darr[0][2] = String.valueOf(Mtotal);
        size2Darr[1][2] = String.valueOf(XLtotal);
        size2Darr[2][2] = String.valueOf(XStotal);
        size2Darr[3][2] = String.valueOf(Stotal);
        size2Darr[4][2] = String.valueOf(XXLtotal);
        size2Darr[5][2] = String.valueOf(Ltotal);

        for (int i = 0; i < size2Darr.length; i++) {
            System.out.println(Arrays.toString(size2Darr[i]));
        }

        for (int i = 5; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (Integer.parseInt(size2Darr[j][2]) < Integer.parseInt(size2Darr[j + 1][2])) {
                    String[] temp = size2Darr[j];
                    size2Darr[j] = size2Darr[j + 1];
                    size2Darr[j + 1] = temp;
                }
            }
        }

        System.out.printf("\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");
        System.out.printf("\t\t\t|%15s %8s %14s\n", "      Size          |", "     QTY     |", "    Amount        |");
        System.out.printf("\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        for (int i = 0; i < size2Darr.length; i++) {
            System.out.printf("\t\t\t| %15s    | %8s     |  %14s   |\n", size2Darr[i][0], size2Darr[i][1],
                    size2Darr[i][2]);
            System.out.printf("\t\t\t| %15s    |%8s      |  %14s   |\n", "", "", "");
        }
        System.out.printf("\t\t\t%15s+%8s+%14s\n", "+--------------------", "--------------", "-------------------+");

        System.out.println();
        System.out.print("To access the Main Menu,Please enter 0 :");
        int main = input.nextInt();
        if (main == 0) {
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

        System.out.print("Enter option:");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option) {
            case 1:
                allorders();
                break;
            case 2:
                ordersamount();
                break;
            default:
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

        System.out.println();
        Scanner input = new Scanner(System.in);

        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");
        System.out.printf("\t\t\t\t|%10s %5s %5s %5s %5s %5s\n", "      Order ID   |", "Customer ID |", " size  |",
                "  Qty  |", " Amount  |", " Status  |");
        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s \n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        for (int i = contactnumber.length - 1; i >= 0; i--) {

            System.out.printf("\t\t\t\t|%10s       |%5s   |%5s   |%5d   |%5.2f   |%5d     |\n", idarray[i],
                    contactnumber[i], tshirtsizearray[i], qtyarray[i], amountarray[i], Statusar[i]);
            System.out.printf("\t\t\t\t|%10s       |%5s        |%5s   |%5s   |%5s     |%5s     |\n", "", "", "", "", "",
                    "", "", "");

        }
        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        System.out.println();

        System.out.print("To access the Main Menu,Please enter 0 :");

        int main = input.nextInt();
        if (main == 0) {
            main(null);
        } else {
            clearConsole();
            allorders();
        }
    }

    public static void ordersamount() {
        System.out
                .println("   ____          _                 ____                                               _   ");
        System.out.println(
                "  / __ \\        | |               |  _ \\            /\\                               | |  ");
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

        for (int i = contactnumber.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (amountarray[j] < amountarray[j + 1]) {
                    double temp = amountarray[j];
                    amountarray[j] = amountarray[j + 1];
                    amountarray[j + 1] = temp;

                    String idtemp = idarray[j];
                    idarray[j] = idarray[j + 1];
                    idarray[j + 1] = idtemp;

                    String contacttemp = contactnumber[j];
                    contactnumber[j] = contactnumber[j + 1];
                    contactnumber[j + 1] = contacttemp;

                    String sizetemp = tshirtsizearray[j];
                    tshirtsizearray[j] = tshirtsizearray[j + 1];
                    tshirtsizearray[j + 1] = sizetemp;

                    int qttemp = qtyarray[j];
                    qtyarray[j] = qtyarray[j + 1];
                    qtyarray[j + 1] = qttemp;

                    int ststemp = Statusar[j];
                    Statusar[j] = Statusar[j + 1];
                    Statusar[j + 1] = qttemp;
                }
            }
        }

        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");
        System.out.printf("\t\t\t\t|%10s %5s %5s %5s %5s %5s\n", "      Order ID   |", "Customer ID |", " size  |",
                "  Qty  |", " Amount  |", " Status  |");
        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s \n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        for (int i = 0; i < contactnumber.length; i++) {

            System.out.printf("\t\t\t\t|%10s       |%5s   |%5s   |%5d   |%10.2f|%5d     |\n", idarray[i],
                    contactnumber[i], tshirtsizearray[i], qtyarray[i], amountarray[i], Statusar[i]);
            System.out.printf("\t\t\t\t|%10s       |%5s        |%5s   |%5s   |%5s     |%5s     |\n", "", "", "", "", "",
                    "", "", "");

        }
        System.out.printf("\t\t\t\t%10s+%5s+%5s+%5s+%5s+%5s\n", "+-----------------", "-------------", "--------",
                "--------", "----------", "----------+");

        System.out.println();

        System.out.print("To access the Main Menu,Please enter 0 :");

        int main = input.nextInt();
        if (main == 0) {
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

        for (int i = 0; i < contactnumber.length; i++) {
            if (odrID.equals(idarray[i])) {
                isfound = true;
                System.out.println("Phone Number :" + contactnumber[i]);
                System.out.println("Size         :" + tshirtsizearray[i]);
                System.out.println("QTY          :" + qtyarray[i]);
                System.out.println("Amount       :" + amountarray[i]);
                if (Statusar[i] == 0) {
                    System.out.println("Status       : processing");
                } else if (Statusar[i] == 1) {
                    System.out.println("Status       : Delivering");
                } else if (Statusar[i] == 0) {
                    System.out.println("Status       : Delivered");
                }

                System.out.println();

                switch (Statusar[i]) {
                    case 0:

                        System.out.print("Do you want to change this order status? (y/n) :");
                        char yesno = input.next().charAt(0);

                        if (yesno == 'y' || yesno == 'Y') {
                            System.out.println("\n\t[1] Order Delivering");
                            System.out.println("\t[2] Order Delivered");
                            System.out.print("\nEnter option :");
                            int option = input.nextInt();

                            switch (option) {
                                case 1:
                                    Statusar[i] = Delivering;
                                    System.out.println("Status Updated");
                                    break;

                                case 2:
                                    Statusar[i] = Delivered;
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
                                    Statusar[i] = Delivered;
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
                        System.out.print("Can't change this order status,Order already delivered..!");

                    default:
                        break;
                }

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
