import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
class Implementation {
	String oint[] = new String[25];
	String tab[] = new String[25];
	String syr[] = new String[25];
	int ointq[] = new int[25];
	int tabq[] = new int[25];
	int syrq[] = new int[25];
	int ointpr[] = new int[25];
	int tabpr[] = new int[25];
	int syrpr[] = new int[25];
}
class Medical {
	public static void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception E) {
			System.out.println(E);
		}
	}
	static int checkname(String n1) {
		int cnt = 0;
		int l1 = n1.length();
		char asv;
		int flag1 = 0;
		if (l1 == 0)
			flag1 = 1;
		for (int ll = 0; ll < l1; ll++) {
			asv = n1.charAt(ll);
			if (ll == 0 && asv == ' ') {
				flag1 = 1;
				break;
			}
			if (asv == ' ')
				cnt++;
			if (cnt == 2) {
				flag1 = 1;
				break;
			}
			if ((asv >= 'A' && asv <= 'Z') || (asv >= 'a' && asv <= 'z') || asv == ' ')
				continue;
			else {
				flag1 = 1;
				break;
			}
		}
		if (flag1 == 1)
			return 1;
		else
			return 0;

	}
	static int checknumber(String num) {
		int l1 = num.length();
		int flag1 = 0;
		if (l1 == 0)
			flag1 = 1;
		else if (((num.charAt(0)) == '9') || ((num.charAt(0)) == '8') || ((num.charAt(0)) == '7') || ((num.charAt(0)) == '6')) {
			flag1 = 0;
		} else
			flag1 = 1;
		if (l1 != 10)
			flag1 = 1;
		else {
			for (int i = 0; i < l1; i++) {
				char ch;
				ch = num.charAt(i);
				if (ch >= '0' && ch <= '9')
					continue;
				else
					flag1 = 1;
			}
		}
		if (flag1 == 1)
			return 1;
		else
			return 0;
	}
	public static void main(String args[])throws Exception {
		Implementation ob1 = new Implementation();
		BufferedReader bf = new BufferedReader(new FileReader("F:/xConsoleApp/Tabletsa.txt"));
		int i = 0, jk, ix = 0;
		String s1;
		int billno = 13425;
		do {
			while ((s1 = bf.readLine()) != null) {
				ob1.tab[i] = s1;
				i++;
			}
			BufferedReader bf1 = new BufferedReader(new FileReader("F:/xConsoleApp/Syrupa.txt"));
			i = 0;
			while ((s1 = bf1.readLine()) != null) {
				ob1.syr[i] = s1;
				i++;
			}
			BufferedReader bf2 = new BufferedReader(new FileReader("F:/xConsoleApp/Ointmentsa.txt"));
			i = 0;
			while ((s1 = bf2.readLine()) != null) {
				ob1.oint[i] = s1;
				i++;
			}
			BufferedReader bf3 = new BufferedReader(new FileReader("F:/xConsoleApp/QtyOint.txt"));
			i = 0;
			while ((s1 = bf3.readLine()) != null) {
				ob1.ointq[i] = Integer.parseInt(s1);
				i++;
			}
			BufferedReader bf4 = new BufferedReader(new FileReader("F:/xConsoleApp/QtyTab.txt"));
			i = 0;
			while ((s1 = bf4.readLine()) != null) {
				ob1.tabq[i] = Integer.parseInt(s1);
				i++;
			}
			BufferedReader bf5 = new BufferedReader(new FileReader("F:/xConsoleApp/QtySyr.txt"));
			i = 0;
			while ((s1 = bf5.readLine()) != null) {
				ob1.syrq[i] = Integer.parseInt(s1);
				i++;
			}
			BufferedReader bf6 = new BufferedReader(new FileReader("F:/xConsoleApp/PriceOint.txt"));
			i = 0;
			while ((s1 = bf6.readLine()) != null) {
				ob1.ointpr[i] = Integer.parseInt(s1);
				i++;
			}
			BufferedReader bf7 = new BufferedReader(new FileReader("F:/xConsoleApp/PriceSyr.txt"));
			i = 0;
			while ((s1 = bf7.readLine()) != null) {
				ob1.syrpr[i] = Integer.parseInt(s1);
				i++;
			}
			BufferedReader bf8 = new BufferedReader(new FileReader("F:/xConsoleApp/PriceTab.txt"));
			i = 0;
			while ((s1 = bf8.readLine()) != null) {
				ob1.tabpr[i] = Integer.parseInt(s1);
				i++;
			}
			String name;
			System.out.println("\nHello Customer " + (++ix));
			System.out.println("enter the name of the customer");
			int l1;
			Scanner sc = new Scanner(System.in);
			name = sc.nextLine();
			l1 = checkname(name);
			while (l1 == 1) {
				System.out.println("enter valid name");
				name = sc.nextLine();
				l1 = checkname(name);
			}
			String mob;
			System.out.println("enter the 10-digit mobile number of the customer");
			int b;
			mob = sc.nextLine();
			b = checknumber(mob);
			while (b == 1) {
				System.out.println("enter valid 10-digit mobile number");
				mob = sc.nextLine();
				b = checknumber(mob);
			}
			int n;
			String ss;
			System.out.println("enter the different number of items you want to buy");
			while (true) {
				try {
					n = sc.nextInt();
					if (n < 0) {
						System.out.println("enter a valid number");
						continue;
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Enter Valid number of items");
					ss = sc.nextLine();
				}
			}

			int tp = 0;
			String medn[] = new String[n];
			int qu[] = new int[n];
			for (int j = 0; j < n; j++) {
				System.out.println("enter your choice");
				System.out.println("Press 1 for tablets");
				System.out.println("Press 2 for ointments");
				System.out.println("Press 3 for syrups");
				int ch, sno, qty;
				String ss1;
				while (true) {
					try {
						ch = sc.nextInt();
						if (ch > 3 || ch < 0) {
							System.out.println("enter valid choice");
							continue;
						}
						break;
					} catch (InputMismatchException e) {
						System.out.println("Enter Valid choice");
						ss1 = sc.nextLine();
					}
				}

				switch (ch) {
				case 1:
					BufferedReader bf9 = new BufferedReader(new FileReader("F:/xConsoleApp/Tablets.txt"));
					System.out.println("the list of tablets is as follows");
					while ((s1 = bf9.readLine()) != null) {
						System.out.println(s1);
					}
					System.out.println("enter the quantity of medicine needed");
					while (true) {
						try {
							qty = sc.nextInt();
							if (qty < 1) {
								System.out.println("enter a valid input");
								continue;
							}
							break;
						} catch (InputMismatchException e) {
							System.out.println("Enter Valid quantity");
							ss1 = sc.nextLine();
						}
					}
					System.out.println("enter the serial number of the medicine you want");
					while (true) {
						try {
							sno = sc.nextInt();
							if (sno > 25 || sno < 1) {
								System.out.println("enter a valid serial number");
								continue;
							}
							break;
						} catch (InputMismatchException e) {
							System.out.println("Enter Valid serial number");
							ss1 = sc.nextLine();
						}
					}
					if (sno > 25) {
						System.out.println("please enter a valid serial number");
						j--;
					} else if (ob1.tabq[sno - 1] == 0) {
						System.out.println("sorry,the given tablet is not available");
					} else if (qty > ob1.tabq[sno - 1]) {
						System.out.println("sorry,currently we have only " + ob1.tabq[sno - 1] + " quantity available");
						System.out.println("would you like to buy all of the available");
						System.out.println("Press 1 for yes and press 2 for no");
						int cho;
						cho = sc.nextInt();
						if (cho == 1) {
							tp = tp + (ob1.tabq[sno - 1] * ob1.tabpr[sno - 1]);
							qu[j] = ob1.tabq[sno - 1];
							ob1.tabq[sno - 1] = 0;
							medn[j] = ob1.tab[sno - 1];

						} else {
							medn[j] = ob1.tab[sno - 1];
							qu[j] = 0;
						}
					} else {

						tp = tp + qty * ob1.tabpr[sno - 1];
						medn[j] = ob1.tab[sno - 1];
						qu[j] = qty;
						ob1.tabq[sno - 1] = ob1.tabq[sno - 1] - qty;
					}
					break;
				case 2:
					BufferedReader bf10 = new BufferedReader(new FileReader("F:/xConsoleApp/Ointments.txt"));
					System.out.println("the list of ointments is as follows");
					while ((s1 = bf10.readLine()) != null) {
						System.out.println(s1);
					}
					System.out.println("enter the quantity of medicine needed");
					while (true) {
						try {
							qty = sc.nextInt();
							if (qty < 1) {
								System.out.println("enter a valid input");
								continue;
							}
							break;
						} catch (InputMismatchException e) {
							System.out.println("Enter Valid quantity");
							ss1 = sc.nextLine();
						}
					}
					System.out.println("enter the serial number of the medicine you want");
					while (true) {
						try {
							sno = sc.nextInt();
							if (sno > 25 || sno < 1) {
								System.out.println("enter a valid serial number");
								continue;
							}
							break;
						} catch (InputMismatchException e) {
							System.out.println("Enter Valid serial number");
							ss1 = sc.nextLine();
						}
					}
					if (sno > 25) {
						System.out.println("please enter a valid serial number");
						j--;
					}

					else if (ob1.ointq[sno - 1] == 0) {
						System.out.println("sorry,the given ointment is not available");
					} else if (qty > ob1.ointq[sno - 1]) {
						System.out.println("sorry,currently we have only " + ob1.ointq[sno - 1] + " quantity available");
						System.out.println("would you like to buy all of the available");
						System.out.println("Press 1 for yes and press 2 for no");
						int cho;
						cho = sc.nextInt();
						if (cho == 1) {
							tp = tp + (ob1.ointq[sno - 1] * ob1.ointpr[sno - 1]);
							medn[j] = ob1.oint[sno - 1];
							qu[j] = ob1.ointq[sno - 1];
							ob1.ointq[sno - 1] = 0;

						} else {
							medn[j] = ob1.oint[sno - 1];
							qu[j] = 0;
						}
					} else {
						tp = tp + qty * ob1.ointpr[sno - 1];
						medn[j] = ob1.oint[sno - 1];
						qu[j] = qty;
						ob1.ointq[sno - 1] = ob1.ointq[sno - 1] - qty;
					}
					break;
				case 3:
					BufferedReader bf11 = new BufferedReader(new FileReader("F:/xConsoleApp/Syrup.txt"));
					System.out.println("the list of syrups is as follows");
					while ((s1 = bf11.readLine()) != null) {
						System.out.println(s1);
					}
					System.out.println("enter the quantity of medicine needed");
					while (true) {
						try {
							qty = sc.nextInt();
							if (qty < 1) {
								System.out.println("enter a valid input");
								continue;
							}
							break;
						} catch (InputMismatchException e) {
							System.out.println("Enter Valid quantity");
							ss1 = sc.nextLine();
						}
					}
					System.out.println("enter the serial number of the medicine you want");
					while (true) {
						try {
							sno = sc.nextInt();
							if (sno > 25 || sno < 1) {
								System.out.println("enter a valid serial number");
								continue;
							}
							break;
						} catch (InputMismatchException e) {
							System.out.println("Enter Valid serial number");
							ss1 = sc.nextLine();
						}
					}
					if (sno > 25) {
						System.out.println("please enter a valid serial number");
						j--;
					} else if (ob1.syrq[sno - 1] == 0) {
						System.out.println("sorry,the given syrup is not available");
					} else if (qty > ob1.syrq[sno - 1]) {
						System.out.println("sorry,currently we have only " + ob1.syrq[sno - 1] + " quantity available");
						System.out.println("would you like to buy all of the available");
						System.out.println("Press 1 for yes and press 2 for no");
						int cho;
						cho = sc.nextInt();
						if (cho == 1) {
							tp = tp + (ob1.syrq[sno - 1] * ob1.syrpr[sno - 1]);
							medn[j] = ob1.syr[sno - 1];
							qu[j] = ob1.syrq[sno - 1];
							ob1.syrq[sno - 1] = 0;

						} else {
							medn[j] = ob1.syr[sno - 1];
							qu[j] = 0;
						}
					} else {
						tp = tp + qty * ob1.syrpr[sno - 1];
						medn[j] = ob1.syr[sno - 1];
						qu[j] = qty;
						ob1.syrq[sno - 1] = ob1.syrq[sno - 1] - qty;
					}
					break;
				default:
					System.out.println("please enter a valid choice");
					j--;
				}
			}
			System.out.println();
			System.out.println("the total amount of the bill is " + tp);
			System.out.println("the amount given by customer is");
			int paid, change;
			String ss1;
			while (true) {
				try {
					paid = sc.nextInt();
					if (paid < 0) {
						System.out.println("enter a valid amount");
						continue;
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Enter Valid amount");
					ss1 = sc.nextLine();
				}
			}
			cls();
			if (paid < tp) {
				System.out.println("Please pay Rs." + (tp - paid) + " more");
				paid = tp;
				change = 0;
			} else {
				change = paid - tp;
			}
			System.out.println();
			System.out.println();
			System.out.println("-------------The bill generated is:--------------");
			System.out.println("NAME: " + name);
			System.out.println("MOBILE NUMBER: " + mob);
			System.out.println("BILL NUMBER:" + billno);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			String x1 = formatter.format(date);
			System.out.print("\nDATE: ");
			System.out.print(formatter.format(date));
			formatter = new SimpleDateFormat("hh:mm:ss");
			Date date1 = new Date();
			System.out.print("\nTIME: ");
			System.out.print(formatter.format(date1));
			System.out.println("\nthe list of items taken is");
			System.out.println("item                      quantity");

			for (int j = 0; j < n; j++) {
				System.out.println();
				System.out.print(medn[j]);
				System.out.print("      ");
				int l = medn[j].length();
				for (int k = 0; k < 21 - l; k++)
					System.out.print(" ");
				System.out.print(qu[j]);

			}
			System.out.println();
			System.out.println("----------------------------------");
			System.out.print("TOTAL                     ");
			System.out.print(tp);
			System.out.println();
			System.out.print("PAID                      ");
			System.out.print(paid);
			System.out.println();
			System.out.print("CHANGE                    ");
			System.out.print(change);
			BufferedWriter bf12 = new BufferedWriter(new FileWriter("F:/xConsoleApp/QtyTab.txt"));
			for (int l = 0; l < 25; l++) {
				bf12.write(String.valueOf(ob1.tabq[l]));
				if (l != 24)
					bf12.newLine();
			}
			bf12.close();
			BufferedWriter bf13 = new BufferedWriter(new FileWriter("F:/xConsoleApp/QtySyr.txt"));
			for (int l = 0; l < 25; l++) {
				bf13.write(String.valueOf(ob1.syrq[l]));
				if (l != 24)
					bf13.newLine();
			}
			bf13.close();
			BufferedWriter bf14 = new BufferedWriter(new FileWriter("F:/xConsoleApp/QtyOint.txt"));
			for (int l = 0; l < 25; l++) {
				bf14.write(String.valueOf(ob1.ointq[l]));
				if (l != 24)
					bf14.newLine();
			}
			bf14.close();
			billno++;
			BufferedWriter bf20 = new BufferedWriter(new FileWriter("F:/xConsoleApp/OutputFile.txt", true));
			bf20.newLine();
			bf20.write(String.valueOf(billno));
			bf20.write("        ");
			int lll = name.length();
			bf20.write(name);
			for (int iii = 0; iii < 20 - lll; iii++) {
				bf20.write(" ");
			}
			bf20.write(x1);
			bf20.write("   ");
			bf20.write(String.valueOf(tp));
			bf20.close();
			System.out.println("\nOnly for Admin" + "\n" + "1.New Customer    2.Exit");
			jk = sc.nextInt();
		} while (jk == 1);
	}
}


