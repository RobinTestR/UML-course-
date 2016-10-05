/**
 *
 */
package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Boat;
import Model.Member;

/**
 * @author Robin
 *
 */



public class Console {

	
	private static Model.Member member = new Member();
	private static Model.Boat boats = new Boat();
	private static Scanner userInput = new Scanner(System.in);
	private ArrayList<String>memberList = new ArrayList<String>();


	public void start(){

		for(int j = 0; j >= 0; j++){
			System.out.println("Welcome, choose from the options: ");
			System.out.println("1.Wanna create a member? Press 1" + "\n" + "2.Wanna list all the members? Press 2" + "\n"
					+ "3.Wanna delete a member? Press 3" + "\n" + "4.Wanna change member information on someone? Press 4."
					+ "\n" + "5.Wanna look at specific member information? Press 5. " + "\n" +"5.Wanna register a boat? Press 6" +"\n" + "7.Wanna delete a boat? Press 7" +"\n" +"8.Wanna change boat information? Press 8" );

			int userInput0 = userInput.nextInt();

			if (userInput0 == 1) {
				for(int i = 0; i <= 0; i--){
				System.out.println("Please enter your name: ");
				String userInput1 = userInput.next();
				member.setName(userInput1);
				
				member.memberInfo.add(member.getName());

				System.out.println("Please add a personal number: ");
				int userInputLine2 = userInput.nextInt();
				member.setPersonalNumber(userInputLine2);
				//System.out.println("Please enter your boat number: ");
				//int userInputLine3 = userInput.nextInt();
				//member.setNumBoats(userInputLine3);
				member.memberInfo2.add(member.getPersonalNumber()+"");
				//member.memberInfo.add(member.combine());
				member.setBoats(0);
				member.numOfBoats.add(member.getBoats());
				member.memberInfo3.add(member.UniqueID());

				System.out.println("Wanna add another member? 1 for yes, 0 for no");
				int userInputLine04 = userInput.nextInt();
				if (userInputLine04 == 0) {

					break;
				}
			   }





				}



			if (userInput0 == 2) {
				System.out.println("The members are: ");
				for (int i = 0; i < member.memberInfo.size(); i++) {

					System.out.println("name: " + member.memberInfo.get(i) + "   Personalnumber:  " + member.memberInfo2.get(i) + "  ID: "+member.memberInfo3.get(i) );
				}
			}

			if (userInput0 == 3) {


				System.out.println("Enter your member ID please: ");
				int userInput2 = userInput.nextInt();
				member.memberInfo.remove(userInput2-1);


			}
			if (userInput0 == 4){
				System.out.println("Whose information do you wanna change?Enter the memberID");
				int tempMemberID = userInput.nextInt();
				System.out.println("What do you wanna change, 1.name or 2.personal ID?");
				int userInput06 = userInput.nextInt();

				if (userInput06 == 1) {
					member.memberInfo.remove(tempMemberID-1);
					System.out.println("What do you want instead?");
					String setNames = userInput.next();
					member.setName(setNames);
					for(int i = 0; i < member.memberInfo3.size(); i++){

						if(i == tempMemberID-1){
							member.memberInfo.add(tempMemberID-1, setNames);
						}
					}

				}

				if (userInput06 == 2) {
					member.memberInfo3.remove(tempMemberID-1);
					System.out.println("What do you want instead?");
					int newPersonalNumber = userInput.nextInt();

					member.setPersonalNumber(newPersonalNumber);

					for(int i = 0; i < member.memberInfo3.size(); i++){

						if(i == tempMemberID-1){
							member.memberInfo3.add(tempMemberID-1, newPersonalNumber);
						}

					}

				}


				System.out.println("Now the information are: Name:   " + member.memberInfo.get(tempMemberID-1)+"   personalID:   "+member.memberInfo2.get(tempMemberID-1) + " PersonalNumber: "+member.memberInfo3.get(tempMemberID-1));

			}
			if(userInput0 == 5){

				System.out.println("Enter your name: ");
				String specificInfo = userInput.next();
				if(userInput.next() == specificInfo){



				}

			}

			if(userInput0 == 6){

				System.out.println("Whats your memberID?");
				int tempMemberID = userInput.nextInt();
				boats.memberID.add(tempMemberID);
				boats.boatIDcounter++;
				boats.boatID.add(boats.boatIDcounter);
				System.out.println("What kinda boat are we talking about here? 1. Sailboat 2. MotorSailer 3. Kayak/Canoe 4. Other");
				int boatTypeTemp = userInput.nextInt();
				if(boatTypeTemp == 1){

					boats.setBoatType("Sailboat");
					boats.typeOfBoats.add(boats.getBoatType());
				}
				if(boatTypeTemp == 2){
					boats.setBoatType("Motorsailer");
					boats.typeOfBoats.add(boats.getBoatType());

				}
				if(boatTypeTemp == 3){
					boats.setBoatType("Kayak/Canoe");
					boats.typeOfBoats.add(boats.getBoatType());

				}
				if(boatTypeTemp == 4){

					boats.setBoatType("Other");
					boats.typeOfBoats.add(boats.getBoatType());
				}

				System.out.println("Whats the length of your boat? Enter in Meters");
				int boatLength = userInput.nextInt();
				boats.setboatLength(boatLength);
				boats.boatLength.add(boatLength);



				member.setBoats(tempMemberID);
				member.addNewBoat(tempMemberID);

			}

			if(userInput0 == 7){

				System.out.println("Whats your memberID?");
				int memberIDForDelete = userInput.nextInt();
				System.out.println("Here are your boats:");
				System.out.println("BoatID        Type       Length");
				for(int i = 0; i < boats.typeOfBoats.size(); i++){
					if(memberIDForDelete == boats.memberID.get(i)){
						System.out.println(boats.boatID.get(i)+"       "+boats.typeOfBoats.get(i)+"       "+boats.boatLength.get(i));
					}
				}
	            System.out.println("Which boat you want to delete?Enter the BoatID!");
	            int boatIDForDelete = userInput.nextInt();
	            for(int i = 0; i < boats.typeOfBoats.size(); i++){
	            	if(boatIDForDelete == boats.boatID.get(i)){
	            		boats.memberID.set(i, 0);
	            		boats.boatLength.set(i, 0);
	            		boats.typeOfBoats.set(i,"");
	            	}
	            }
	            for(int i = 0 ;i < member.memberInfo3.size();i++){
	            	if(memberIDForDelete == member.memberInfo3.get(i)){
	            		member.memberInfo3.set(i, member.memberInfo3.get(i)-1);
	            	}
	            }
			}
			if(userInput0 == 8){

				System.out.println("Enter your memberID");
				int memberIDforChange = userInput.nextInt();
				System.out.println("Here are your boats:");
				System.out.println("BoatID        Type       Length");
				for(int i = 0; i < boats.typeOfBoats.size(); i++){
					if(memberIDforChange == boats.memberID.get(i)){
						System.out.println(boats.boatID.get(i)+"       "+boats.typeOfBoats.get(i)+"       "+boats.boatLength.get(i));
					}
				}

				System.out.println("Which boat do you wanna edit?Enter the boat ID");
				int BoatIDForChange = userInput.nextInt();
				System.out.println("Which column you want to change for the boat/press 1 for changing type/press 2 for changing length ");
				int columnForChange = userInput.nextInt();
				if(columnForChange == 1){
					System.out.println("Which type do you wanna replace? 1. Sailboat 2. MotorSailer 3. Kayak/Canoe 4. Other");
					int boatTypeEdit = userInput.nextInt();
					if(boatTypeEdit == 1){
						boats.typeOfBoats.set(BoatIDForChange-1, "Sailboat");
					}
					if(boatTypeEdit == 2){
						boats.typeOfBoats.set(BoatIDForChange-1, "MotorSailer");
						}
					if(boatTypeEdit == 3){
						boats.typeOfBoats.set(BoatIDForChange-1, "Kayak/Canoe");
						}
					if(boatTypeEdit == 4){
						boats.typeOfBoats.set(BoatIDForChange-1, "Other");
						}
				}
				if(columnForChange == 2){
					System.out.println("What s the length you want to replace?");
					int boatlengthEdit = userInput.nextInt();
					boats.boatLength.set(BoatIDForChange-1, boatlengthEdit);
				}



			}


		}





	}



}
