package Game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Player {
	public static boolean button[] = {false, false, false, false};
	public static int player;
	public static void resetButtons(){
		button[0] = false;
		for(int i = 0; i < button.length; i++){
			button[i] = false;
		}
	} 
	public static void clearButtons(){
		Window.button1.setText("");Window.button2.setText("");Window.button3.setText("");Window.button4.setText("");
		Window.tester.setText(""); Window.card.setText(""); Window.payment.setText("");Window.answer.setText("");
	}
	
	
	protected static String position[] = {"Go","Mediter-ranean Avenue","Community Chest","Baltic Avenue","Income Tax","Reading Railroad","Oriental Avenue","Chance","Vermont Avenue","Connecticut Avenue","Jail//Just Visiting","St.Charles Place","Electric Company","States Avenue","Virginia Avenue","Pennsylvania Railroad","St.James Place","Community Chest","Tennessee Avenue","New York Avenue","Free Parking","Kentucky Avenue","Chance","Indiana Avenue","Illinois Avenue","B&O Railroad","Atlantic Avenue","Ventnor Avenue","Water Works","Marvin Gardens","Go To Jail","Pacific Avenue","North Carolina Avenue","Community Chest","Pennsylvania Avenue","Short Line","Chance","Park Place","Luxury Tax","Boardwalk"};
	protected static int baseCost[] = {0,60,0,60,0,200,100,0,100,120,0,140,150,140,160,200,180,0,180,200,0,220,0,220,240,200,260,260,150,280,0,300,300,0,320,200,0,350,0,400};
	public static boolean propertiesOwned[] = {true, false, true , false, true, false, false, true, false, false, true, false, false, false, false, false, false, true ,false, false, true, false, true, false, false, false, false, false, false, false, true, false, false, true, false, false, true , false, true, false};
	public static int whoOwnsIt[] = {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
	public static int playerMoney[] ={1500,1500,1500,1500};
	public static String playerNames[] = {"Player1","Player2","Player3","Player4"};
	public static int playerPosition[] = {0,0,0,0}; 
	public static int X[] = {900,800,715,635,550,475,390,310,225,140,10,   	25,25,25,25,25,25,25,25,25,25,           140,225,310,390,475,550,635,715,800,900,	925,925,925,925,925,925,925,925,925};
	public static int Y[] = {900,925,925,925,925,925,925,925,925,925,900,	800,715,635,550,465,385,305,225,140,25,	25,25,25,25,25,25,25,25,25,25,            	140,225,305,385,465,550,635,715,800};
	
	public static int numberOfPlayers;
	static Color p1Color = new Color(65, 235, 244);
	static Color p2Color = new Color(244, 65, 65);
	static Color p3Color = new Color(65, 244, 85);
	static Color p4Color = new Color(244, 241, 65);
	
	public static void renderPlayer(Graphics g, int nop){
		int w = 20, h = w, d = w + 10;
		if(nop == 2){
			g.setColor(p1Color);
			g.fillRect(X[playerPosition[0]], Y[playerPosition[0]], w, h);
			g.setColor(p2Color);
			g.fillRect(X[playerPosition[1]]+ d, Y[playerPosition[1]], w, h);
		}else if(nop == 3){
			g.setColor(p1Color);
			g.fillRect(X[playerPosition[0]], Y[playerPosition[0]], w, h);
			g.setColor(p2Color);
			g.fillRect(X[playerPosition[1]]+ d, Y[playerPosition[1]], w, h);
			g.setColor(p3Color);
			g.fillRect(X[playerPosition[2]], Y[playerPosition[2]]+ d, w, h);
		}else if(nop == 4){
			g.setColor(p1Color);
			g.fillRect(X[playerPosition[0]], Y[playerPosition[0]], w, h);
			g.setColor(p2Color);
			g.fillRect(X[playerPosition[1]]+ d, Y[playerPosition[1]], w, h);
			g.setColor(p3Color);
			g.fillRect(X[playerPosition[2]], Y[playerPosition[2]]+ d, w, h);
			g.setColor(p4Color);
			g.fillRect(X[playerPosition[3]]+ d, Y[playerPosition[3]]+ d, w, h);
		}	
	}
	
	public static void renderPlayerInfo(Graphics g, int nop){
		int x = 145, y = 165;
		String temp = "Name" + space(20, "name") + "$" +  space(12,"$") + "Location" + space(25, "Location") + "#ofthingsOwned";
		String p1 = playerNames[0] + space(20,playerNames[0]) + playerMoney[0] + space(10, Integer.toString(playerMoney[0])) + getPosition(0) + space(25, getPosition(0)) + getNumberOfProperty(0);
		String p2 = playerNames[1] + space(20,playerNames[1]) + playerMoney[1] + space(10, Integer.toString(playerMoney[1])) + getPosition(1) + space(25, getPosition(1)) + getNumberOfProperty(1);
		String p3 = playerNames[2] + space(20,playerNames[2]) + playerMoney[2] + space(10, Integer.toString(playerMoney[2])) + getPosition(2) + space(25, getPosition(2)) + getNumberOfProperty(2);
		String p4 = playerNames[3] + space(20,playerNames[3]) + playerMoney[3] + space(10, Integer.toString(playerMoney[3])) + getPosition(3) + space(25, getPosition(3)) + getNumberOfProperty(3);
		Window.info.setBounds(x, y -20, temp.length() *6, 15);
		Window.info.setText(temp);
		if(nop == 2){
			y+=15;Window.player1Info.setBounds(x, y -20, p1.length() *6, 15);Window.player1Info.setText(p1);
			y+=15;Window.player2Info.setBounds(x, y -20, p2.length() *6, 15);Window.player2Info.setText(p2);
		}else if(nop == 3){
			y+=15;Window.player1Info.setBounds(x, y -20, p1.length() *6, 15);Window.player1Info.setText(p1);
			y+=15;Window.player2Info.setBounds(x, y -20, p2.length() *6, 15);Window.player2Info.setText(p2);
			y+=15;Window.player3Info.setBounds(x, y -20, p3.length() *6, 15);Window.player3Info.setText(p3);
		}else if(nop == 4){
			y+=15;Window.player1Info.setBounds(x, y -20, p1.length() *6, 15);Window.player1Info.setText(p1);
			y+=15;Window.player2Info.setBounds(x, y -20, p2.length() *6, 15);Window.player2Info.setText(p2);
			y+=15;Window.player3Info.setBounds(x, y -20, p3.length() *6, 15);Window.player3Info.setText(p3);
			y+=15;Window.player4Info.setBounds(x, y -20, p4.length() *6, 15);Window.player4Info.setText(p4);
		}	
	}
	
	public static String space(int s, String a){
		String temp = "";
		s = s-a.length();
		for(int i = 1; i < s; i++){
			temp += " ";
		}
		return temp;
	}
	
	//get were the player is
	public static String getPosition(int i){
		return position[playerPosition[i]] + "(" + playerPosition[i] + ")"; 
	}
	public static String getPositionL(int l){
		return position[l] ; 
	}

	public static boolean snakeEyes;
	public static int dice1, dice2, numOfSE;
	public static int roll(){
		dice1 = (int) (6 * Math.random() + 1);
		dice2 = (int) (6 * Math.random() + 1);
		if(dice1 ==  dice2){numOfSE++;snakeEyes = true;}
		if(dice1 !=  dice2){numOfSE = 0;snakeEyes = false;}
		Window.dice1.setText("   " + Integer.toString(dice1));
		Window.dice2.setText("   " + Integer.toString(dice2));
		return dice1 + dice2;
	}
	
	public static boolean reRoll = true, buy = false;
	public static void getChoices(int i, boolean r, boolean b){
		if(endGame() == false){
			String temp = "GAME OVER";
			Window.choices.setText(temp);
		}else if(playerInJail[i] == 0){
			if(getOutOfJailFreeCard[i] > 0 && Player.numberOfTurnsInJail[i] > 4){
				String temp = Player.playerNames[i] + " would you like to pay $50 ,end turn or use get out of jail card";
				Window.choices.setText(temp);
				Window.button1.setText("");
				Window.button2.setText("$50");
				Window.button3.setText("Card");
				Window.button4.setText("End turn");
			} else if(getOutOfJailFreeCard[i] == 0 && Player.numberOfTurnsInJail[i] < 4){
				String temp = Player.playerNames[i] + " would you like to roll, pay $50 or end turn";
				Window.choices.setText(temp);
				Window.button1.setText("Roll");
				Window.button2.setText("$50");
				Window.button4.setText("End turn");
			} else if (getOutOfJailFreeCard[i] > 0){
				String temp = Player.playerNames[i] + " would you like to roll, pay $50 ,use get out of jail card, or end turn";
				Window.choices.setText(temp);
				Window.button1.setText("Roll");
				Window.button2.setText("$50");
				Window.button3.setText("Card");
				Window.button4.setText("End turn");
			}else{
				String temp = Player.playerNames[i] + " would you like to pay $50 or end turn";
				Window.choices.setText(temp);
				Window.button1.setText("");
				Window.button2.setText("$50");
				Window.button3.setText("");
				Window.button4.setText("End turn");
			}
		}else if(b &&  1 < Player.getCost(i) &&  whoOwnsIt[playerPosition[i]] == 4 ){
			String temp = Player.playerNames[i] + " would you like to buy " + Player.getPosition(i) + " for $" + Player.getCost(i);
			Window.choices.setText(temp);
			Window.button1.setText("Yes");
			Window.button2.setText("No");
		}else if(r){
			String temp = playerNames[i] + " what whould you like to do";
			Window.choices.setText(temp);
			Window.button1.setText("Roll");
		}else if (!r){
			String temp = playerNames[i] + " what whould you like to do";
			Window.choices.setText(temp);
			Window.button1.setText("End turn");
		}
	}
	
	public static int getCost(int i){
		return baseCost[playerPosition[i]];
	}
	
	public static ArrayList<Integer> player1 = new ArrayList<Integer>();
	public static ArrayList<Integer> player2 = new ArrayList<Integer>();
	public static ArrayList<Integer> player3 = new ArrayList<Integer>();
	public static ArrayList<Integer> player4 = new ArrayList<Integer>();
	public static ArrayList[] owned ={player1, player2, player3, player4};
	
	public static void sellProperty(int i, int l){
		for(int x = 0; x < owned[i].size(); i++){
			if(player1.get(x) == l){
				if(i == 0){
					player1.remove(x);
				}else if(i == 1){
					player2.remove(x);
				}else if(i == 2){
					player3.remove(x);
				}else if(i == 3){
					player4.remove(x);
				}
			break;
			}
		}
	}
	
	 public static void addProperty(int i){// i = player
		 whoOwnsIt[playerPosition[i]] = i;
	 }
	
	 public static int getNumberOfProperty(int i){// p = location i = player
		 int temp = 0;
		 for(int x = 0; x < whoOwnsIt.length; x++){
			 if(whoOwnsIt[x] == i){
				 temp++;
			 }
		 }
		 return temp;
	 }
	 
	 public static void removeProperty(int i, int p){
		 if(i == 0){
			 for(int x = 0; x < player1.size(); x++){
				 if(x == p){
					 player1.remove(x);
					 break;
				 }
			 } 
		 } else  if(i == 1){
			 for(int x = 0; x < player2.size(); x++){
				 if(x == p){
					 player2.remove(x);
					 break;
				 }
			 }
		 } else  if(i == 2){
			 for(int x = 0; x < player3.size(); x++){
				 if(x == p){
					 player3.remove(x);
					 break;
				 }
			 }
		 }else  if(i == 3){
			 for(int x = 0; x < player4.size(); x++){
				 if(x == p){
					 player4.remove(x);
					 break;
				 }
			 }
		 } 
	 }
	 
	 
	public static int tester = 0;
	public static void tester(int i, int d1, int d2){
		passGo(i);
		monopolychecker();
		rent();
		communityChestCards(i);
		chanceCards(i);
		seeIfOwned(i, d1, d2);
		tax(i);
		jail(i);
	}
	
	public static void passGo(int i){
		if(Player.playerPosition[i] > 39){
			Player.playerPosition[i] = (Player.playerPosition[i]%39) -1;
			playerMoney[i] += 200;
			String temp = Player.playerNames[i] + " you collected $200 for passing Go(0)";
			Window.tester.setText(temp);
		}
	}
	
	public static void tax(int i){
		if(playerPosition[i] == 4){
			playerMoney[i] -= 200; 
			String temp = Player.playerNames[i] + " you payed income tax($200)";
			Window.tester.setText(temp);
		}else if(playerPosition[i] == 38){
			playerMoney[i] -= 100; 
			String temp = Player.playerNames[i] + " you payed luxury tax($100)";
			Window.tester.setText(temp);
		}
	}
	//make the player in jail change the x and y
	public static int numberOfTurnsInJail[] ={0,0,0,0};
	public static int playerInJail[] = {1,1,1,1};// 0 = in jail 1 =  not in jail
	public static int getOutOfJailFreeCard[] ={0,0,0,0};
	public static void jail(int i){
		if(playerPosition[i] == 30){
			playerPosition[i] = 10;//goes to jail
			playerInJail[i] -= 1;//make the game know player is in jail
			numberOfTurnsInJail[i] += 4;//how many turns in jail
			reRoll = true;
		}else if (playerInJail[i] == 0){
			playerPosition[i] = 10;//goes to jail
			reRoll = true;
		}
	}
	
	public static void seeIfOwned(int i, int d1, int d2){
		if(whoOwnsIt[playerPosition[i]] != i){
			train(i);
			utility(i, d1, d2);
			avenue(i);
		
			
		}
	}
	
	protected static int trainCost[] = {0,25,50,100,200};
	public static void train(int i){//5,15,25,35
		if(playerPosition[i] == 5 || playerPosition[i] == 15 || playerPosition[i] == 25 || playerPosition[i] == 35){
			if(whoOwnsIt[playerPosition[i]] != 4){
				int nORRO = howManyRROwned(i);
				playerMoney[whoOwnsIt[playerPosition[i]]] += trainCost[nORRO]*(railroadMul);
				playerMoney[i] -= trainCost[nORRO]*(railroadMul);
				String temp = playerNames[i] + " you paid $"  + trainCost[nORRO]*(railroadMul) + " to " + playerNames[whoOwnsIt[playerPosition[i]]] + " for landing on " + getPosition(i);
				Window.payment.setText(temp);
			}
		}
		railroadMul = 1;
	}
	
	public static int howManyRROwned(int i){
		int PWOI = whoOwnsIt[playerPosition[i]];//player that owns the railRoad
		int n = 0;
		for(int x = 5;x < 36; x += 10){
			if(whoOwnsIt[x] == PWOI){
				n++;
			}
		}
		return n;
	}

	protected static int utilitiesCost[] = {0,4,10};
	public static void utility(int i, int d1, int d2){//7 28
		if(playerPosition[i] == 12 || playerPosition[i] == 28){
			int nOUO = howManyUOwned(i);
			if(whoOwnsIt[playerPosition[i]] != 4){
				if(utilityMul != 10){
					playerMoney[whoOwnsIt[playerPosition[i]]] += ((d1+d2) * utilitiesCost[nOUO]);
					playerMoney[i] -= trainCost[nOUO];
					String temp = playerNames[i] + " you paid $"  + ((d1+d2) * utilitiesCost[nOUO]) + " to " + playerNames[whoOwnsIt[playerPosition[i]]] + " for landing on " + getPosition(i);
					Window.payment.setText(temp);
				}else if(utilityMul == 10){
					roll();
					playerMoney[whoOwnsIt[playerPosition[i]]] += (dice1 + dice2)*10;
					playerMoney[i] -= (dice1 + dice2)*10;;
					String temp = playerNames[i] + " you paid $"  + (dice1 + dice2)*10 + " to " + playerNames[whoOwnsIt[playerPosition[i]]] + " for landing on " + getPosition(i);
					Window.payment.setText(temp);
				}
			}
		}
		utilityMul = 1;
	}
	
	public static int howManyUOwned(int i){
		int PWOI = whoOwnsIt[playerPosition[i]];//player that owns the  utility
		int n = 0;
		for(int x = 12;x < 29; x += 16){
			if(whoOwnsIt[x] == PWOI){
				n++;
			}
		}
		return n;
	}
	
	public static void house(Graphics g, int x, int y){// 80 long // 30 down
		g.setColor(Color.gray);
		g.fillRect(x, y, 20, 20);
		g.setColor(Color.darkGray);
		g.fillRect(x, y + 8, 20, 4);
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x, y, 20, 20);
	}
	
	public static int houseX[] = {790,625,380,215,133,	105,105,105,105,105,105,   133,297,380,543,625,790,    873,873,873,873,873};
	public static int houseY[] = {875,875,875,875,875,  789,625,543,379,215,133,   105,105,105,105,105,105,    133,215,379,625,789};
	public static void renderHouse(Graphics g){//0 10 20 30
		for(int k = 0; k <  avenue.length; k++)
		{
			int scale = 20;
			if((0 <  avenue[k] && avenue[k] < 10) || (20 <  avenue[k] && avenue[k] < 30)){
				if(avenueLevel[avenue[k]] == 4){
					house(g,houseX[k], houseY[k]);
					house(g,houseX[k] + scale, houseY[k]);
					house(g,houseX[k] + scale*2, houseY[k]);
					house(g,houseX[k] + scale*3, houseY[k]);
				}else if(avenueLevel[avenue[k]] == 3){
					house(g,houseX[k], houseY[k]);
					house(g,houseX[k] + scale, houseY[k]);
					house(g,houseX[k] + scale*2, houseY[k]);
				}else if(avenueLevel[avenue[k]] == 2){
					house(g,houseX[k], houseY[k]);
					house(g,houseX[k] + scale, houseY[k]);
				}else if(avenueLevel[avenue[k]] == 1){
					house(g,houseX[k], houseY[k]);
				}
			}else if((10 <  avenue[k] && avenue[k] < 20) || (30 <  avenue[k] && avenue[k] < 40))
			{
				if(avenueLevel[avenue[k]] == 4){
					house(g,houseX[k], houseY[k]);
					house(g,houseX[k], houseY[k] + scale);
					house(g,houseX[k], houseY[k] + scale*2);
					house(g,houseX[k], houseY[k] + scale*3);
				}else if(avenueLevel[avenue[k]] == 3){
					house(g,houseX[k], houseY[k]);
					house(g,houseX[k], houseY[k] + scale);
					house(g,houseX[k], houseY[k] + scale*2);
				}else if(avenueLevel[avenue[k]] == 2){
					house(g,houseX[k], houseY[k]);
					house(g,houseX[k], houseY[k] + scale);
				}else if(avenueLevel[avenue[k]] == 1){
					house(g,houseX[k], houseY[k]);
				}
			}
		}
	}
	
	static Color hotel1 = new Color(244, 182, 66);
	static Color hotel2 = new Color(244, 158, 66);
	public static void hotel(Graphics g, int x, int y, int orientation){//0 = -// 1 = |
		if(orientation == 0){
			g.setColor(hotel1);
			g.fillRect(x + 8, y - 1, 60, 20);
			g.setColor(hotel2);
			g.fillRect(x + 8, y + 7, 60, 4);
		}else if(orientation == 1){
			g.setColor(hotel1);
			g.fillRect(x + 1, y + 8, 20, 60);
			g.setColor(hotel2);
			g.fillRect(x + 9, y + 8, 4, 60);
		}
	}
	
	public static void renderHotel(Graphics g){
		for(int k = 0; k <  avenue.length; k++)
		{
			if((0 <  avenue[k] && avenue[k] < 10) || (20 <  avenue[k] && avenue[k] < 30))
			{int o = 0;	
				if(avenueLevel[avenue[k]] == 5){
					hotel(g,houseX[k], houseY[k],o);
				}
			}else if((10 <  avenue[k] && avenue[k] < 20) || (30 <  avenue[k] && avenue[k] < 40))
			{int o = 1;	
				if(avenueLevel[avenue[k]] == 5){
					hotel(g,houseX[k], houseY[k],o);
				}
			}
		}
	}
	
	protected static int canBuy[] = {1,3,5,6,8,9,11,12,13,14,15,16,18,19,21,23,24,25,26,27,28,29,31,32,34,35,37,39};
	public static int rOX[] = {790,625,460,380,215,133,	 105,105,105,105,105,105,105,105,   133,297,380,460,543,625,706,790,    873,873,873,873,873,873};
	public static int rOY[] = {875,875,875,875,875,875,  789,706,625,543,460,379,215,133,   105,105,105,105,105,105,105,105,    133,215,379,460,625,789};
	public static void drawOwners(Graphics g, int x, int y, int o){
		if(0 < o && o < 10){
			g.fillRect(x -1, y - 12, 80, 10);
		}else if(10 < o && o < 20){
			g.fillRect(x , y, 35, 80);
		}else if(20 < o && o < 30){
			g.fillRect(x , y - 6, 80, 40);
		}else if(30 < o && o < 40){
			g.fillRect(x - 10 , y, 10, 80);
		}

	}
	
	static Color blank = new Color(238,238,238);
	public static void renderOwners(Graphics g){
		for(int x = 0; x < canBuy.length ;x++)
		{
			if(whoOwnsIt[canBuy[x]] != 4){
				if(whoOwnsIt[canBuy[x]] == 0)
				{
					g.setColor(p1Color);
					drawOwners(g, rOX[x], rOY[x], canBuy[x]);
				}else if(whoOwnsIt[canBuy[x]] == 1)
				{
					g.setColor(p2Color);
					drawOwners(g, rOX[x], rOY[x], canBuy[x]);
				}else if(whoOwnsIt[canBuy[x]] == 2)
				{
					g.setColor(p3Color);
					drawOwners(g, rOX[x], rOY[x], canBuy[x]);
				}else if(whoOwnsIt[canBuy[x]] == 3)
				{
					g.setColor(p4Color);
					drawOwners(g, rOX[x], rOY[x], canBuy[x]);
				}
			}else{
				g.setColor(blank);
				drawOwners(g, rOX[x], rOY[x], canBuy[x]);
			}
		}
	}	
	
	public static int rent1House[] = {0,10,0,20,0,0,30,0,30,40,0,50,0,50,60,0,70,0,70,80,0,90,0,90,100,0,110,110,0,120,0,130,130,0,150,0,0,175,0,200};
	public static int rent2House[] = {0,30,0,60,0,0,90,0,90,100,0,150,0,150,180,0,200,0,200,220,0,250,0,250,300,0,330,330,0,360,0,390,390,0,450,0,0,500,0,600};
	public static int rent3House[] = {0,90,0,180,0,0,270,0,270,300,0,450,0,450,500,0,550,0,550,600,0,700,0,700,750,0,800,800,0,850,0,900,900,0,1000,0,0,1100,0,1400													                                                };
	public static int rent4House[] = {0,160,0,320,0,0,400,0,400,450,0,625,0,625,700,0,750,0,750,800,0,875,0,875,925,0,975,975,0,1025,0,1100,1100,0,1200,0,0,1300,0,1700};
	public static int rentHotel[] =  {0,250,0,450,0,0,550,0,550,600,0,750,0,750,900,0,950,0,950,1000,0,1050,0,1050,1100,0,1150,1150,0,1200,0,1275,1275,0,1400,0,0,1500,0,2000};
	public static int mortgage[] = 	 {0,30,0,30,0,0,50,0,50,60,0,70,0,70,80,0,90,0,90,100,0,110,0,110,120,0,130,130,0,140,0,150,150,0,160,0,0,175,0,200};
	public static int costOfBuilding[] = {0,50,0,50,0,0,50,0,50,50,0,100,0,100,100,0,100,0,100,100,0,150,0,150,150,0,150,150,0,140,0,200,200,0,200,0,0,200,0,200};
	public static int avenueLevel[] ={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};//5 = hotel
	protected static int avenue[] = {1,3,6,8,9,11,13,14,16,18,19,21,23,24,26,27,29,31,32,34,37,39};
	public static void avenue(int i){
		if(whoOwnsIt[playerPosition[i]] != 4){
			for(int x = 0; x < avenue.length; x++){
				if(playerPosition[i] == avenue[x]){
					playerMoney[whoOwnsIt[playerPosition[i]]] += rent[playerPosition[i]];
					playerMoney[i] -= rent[playerPosition[i]];
					String temp = playerNames[i] + " you paid $"  + rent[playerPosition[i]] + " to " + playerNames[whoOwnsIt[playerPosition[i]]] + " for landing on " + getPosition(i);
					Window.payment.setText(temp);
					break;
				}
			}
		}
	}
	
	public static boolean run = true;
	static int tewfsd = 0;
	public static boolean endGame(){
		boolean endGame = true;
		for(int i = 0; i < 4; i++){
			if(-1*Player.getPlayerOE(i) >= Player.playerMoney[i] &&  tewfsd == 0){
				int temp = 0;
				tewfsd = 1;
				temp = Player.whoOwnsIt[Player.playerPosition[i]];
				run = false;
				System.out.println(playerNames[i] + " you lose");
				Window.button1.setEnabled(false);
				Window.button2.setEnabled(false);
				Window.button3.setEnabled(false);
				Window.button4.setEnabled(false);
				getChoices(i, false, false);
				Window.sell.setVisible(false);
				Window.buy.setVisible(false);
				break;
			}
		}		
		return endGame;
	}
	
	
	
	
	public static int getPlayerOE(int i){
		int temp = 0;
		for(int l = 0; l < 39;l++){
			if(whoOwnsIt[l] == i){
				temp += getMortgageValue(l);
			}
		}
		return temp + playerMoney[i];
	}
	
	public static int getMortgageValue(int location){
		int l = location;
		int temp;
		if(avenueLevel[l] == 5){
			temp = 1;
		}else{
			temp = avenueLevel[l];
		}
		int totalMortgage = mortgage[l] + (costOfBuilding[l]*temp)/2;
		return totalMortgage;
	}
	//1390
	
	
	protected static int baseRent[] = {0,2,0,4,0,0,6,0,6,8,0,10,0,10,12,0,14,0,14,16,0,18,0,18,20,0,22,22,0,24,0,26,26,0,28,0,0,35,0,50};
	public static int rent[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	public static void rent()
	{
		for(int x = 0; x < 40; x++)
		{
			if(avenueLevel[x] != 0)
			{
				if(avenueLevel[x] == 1)
				{
					rent[x] = rent1House[x];
				}else if(avenueLevel[x] == 2)
				{
					rent[x] = rent2House[x];
				}else if(avenueLevel[x] == 3)
				{
					rent[x] = rent3House[x];
				}else if(avenueLevel[x] == 4)
				{
					rent[x] = rent4House[x];
				}else if(avenueLevel[x] == 5)
				{
					rent[x] = rentHotel[x];
				}
			}
		}
	}
	
	
	public static void monopolychecker(){//l is were in the list u are
		for(int x = 0; x < 40;x++){
			rent[x] = baseRent[x];
		}
		for(int x = 0; x < 8; x++){
			if(x == 0){//brown {1,3}
				if(whoOwnsIt[1] != 4 && whoOwnsIt[3] != 4){//see if come owns it
					if(whoOwnsIt[1] == whoOwnsIt[3]){//if the same person owns it;
						if(avenueLevel[1] == 0){
							rent[1] = rent[1]*2;
						}
						if(avenueLevel[3] == 0){
							rent[3] = rent[3]*2;
						}
					}
				}
			} else if(x == 1){//light blue {6,8,9}
				int a = 6; int b = 8; int c = 9;
				if(whoOwnsIt[a] != 4 && whoOwnsIt[b] != 4 && whoOwnsIt[c] != 4){//see if come owns it
					if((whoOwnsIt[a] == whoOwnsIt[b]) && (whoOwnsIt[a] == whoOwnsIt[c])){//if the same person owns it;
						if(avenueLevel[a] == 0){
							rent[a] = rent[a]*2;
						}
						if(avenueLevel[b] == 0){
							rent[b] = rent[b]*2;
						}
						if(avenueLevel[c] == 0){
							rent[c] = rent[c]*2;
						}
					}
				}
			} else if(x == 2){//purple {11,13,14}
				int a = 11; int b = 13; int c = 14;
				if(whoOwnsIt[a] != 4 && whoOwnsIt[b] != 4 && whoOwnsIt[c] != 4){//see if come owns it
					if((whoOwnsIt[a] == whoOwnsIt[b]) && (whoOwnsIt[a] == whoOwnsIt[c])){//if the same person owns it;
						if(avenueLevel[a] == 0){
							rent[a] = rent[a]*2;
						}
						if(avenueLevel[b] == 0){
							rent[b] = rent[b]*2;
						}
						if(avenueLevel[c] == 0){
							rent[c] = rent[c]*2;
						}
					}
				}
			} else if(x == 3){//orange {16,18,19}
				int a = 16; int b = 18; int c = 19;
				if(whoOwnsIt[a] != 4 && whoOwnsIt[b] != 4 && whoOwnsIt[c] != 4){//see if come owns it
					if((whoOwnsIt[a] == whoOwnsIt[b]) && (whoOwnsIt[a] == whoOwnsIt[c])){//if the same person owns it;
						if(avenueLevel[a] == 0){
							rent[a] = rent[a]*2;
						}
						if(avenueLevel[b] == 0){
							rent[b] = rent[b]*2;
						}
						if(avenueLevel[c] == 0){
							rent[c] = rent[c]*2;
						}
					}
				}
			} else if(x == 4){//red {21,23,24}
				int a = 21; int b = 23; int c = 24;
				if(whoOwnsIt[a] != 4 && whoOwnsIt[b] != 4 && whoOwnsIt[c] != 4){//see if come owns it
					if((whoOwnsIt[a] == whoOwnsIt[b]) && (whoOwnsIt[a] == whoOwnsIt[c])){//if the same person owns it;
						if(avenueLevel[a] == 0){
							rent[a] = rent[a]*2;
						}
						if(avenueLevel[b] == 0){
							rent[b] = rent[b]*2;
						}
						if(avenueLevel[c] == 0){
							rent[c] = rent[c]*2;
						}
					}
				}
			} else if(x == 5){//yellow {26,27,29}
				int a = 26; int b = 27; int c = 29;
				if(whoOwnsIt[a] != 4 && whoOwnsIt[b] != 4 && whoOwnsIt[c] != 4){//see if come owns it
					if((whoOwnsIt[a] == whoOwnsIt[b]) && (whoOwnsIt[a] == whoOwnsIt[c])){//if the same person owns it;
						if(avenueLevel[a] == 0){
							rent[a] = rent[a]*2;
						}
						if(avenueLevel[b] == 0){
							rent[b] = rent[b]*2;
						}
						if(avenueLevel[c] == 0){
							rent[c] = rent[c]*2;
						}
					}
				}
			} else if(x == 6){//green {31,32,34}
				int a = 31; int b = 32; int c = 34;
				if(whoOwnsIt[a] != 4 && whoOwnsIt[b] != 4 && whoOwnsIt[c] != 4){//see if come owns it
					if((whoOwnsIt[a] == whoOwnsIt[b]) && (whoOwnsIt[a] == whoOwnsIt[c])){//if the same person owns it;
						if(avenueLevel[a] == 0){
							rent[a] = rent[a]*2;
						}
						if(avenueLevel[b] == 0){
							rent[b] = rent[b]*2;
						}
						if(avenueLevel[c] == 0){
							rent[c] = rent[c]*2;
						}
					}
				}
			} else if(x == 7){//blue {37,39}
				int a = 37; int b = 39;
				if(whoOwnsIt[a] != 4 && whoOwnsIt[b] != 4){//see if come owns it
					if((whoOwnsIt[a] == whoOwnsIt[b])){//if the same person owns it;
						if(avenueLevel[a] == 0){
							rent[a] = rent[a]*2;
						}
						if(avenueLevel[b] == 0){
							rent[b] = rent[b]*2;
						}
					}
				}
			}

		}
	}

	public static int numOfHousesOwned(int i){
		int temp = 0;
		for(int x = 0; x < avenueLevel.length ; x++){
			if(whoOwnsIt[x] == i)
			{
				if(avenueLevel[x] != 5)
				{//5 =- hotel
					if(avenueLevel[x] == 4){
						temp += 4;
					} else if(avenueLevel[x] == 3){
						temp += 3;
					}else if(avenueLevel[x] == 2){
						temp += 2;
					}else if(avenueLevel[x] == 1){
						temp += 1;
					}
				}
			}
		}
		return temp;
	}
	
	public static int numOfHotelsOwned(int i){
		int temp = 0;
		for(int x = 0; x < avenueLevel.length ; x++)
		{
			if(whoOwnsIt[x] == i)
			{
				if(avenueLevel[x] == 5)
				{
					temp += 1;
				}
			}
		}
		return temp;
	}
	
	public static void buyHouse(int i,int nOH, int a){//i player; a where house is being bought
		if(whoOwnsIt[a] == i){	
			if(nOH <= (4 - avenueLevel[a]) &&  avenueLevel[a] != 4 && avenueLevel[a] != 4 ){	
				for(int x = 0; x < avenue.length; x++){
					if(a == avenue[x]){
						playerMoney[i] -= nOH*costOfBuilding[a];
						avenueLevel[a] += nOH;// nOH = number of houses
						Window.payment.setText("You bought " + nOH + " houses for $" + nOH*costOfBuilding[a]); 
						break;
					}
				}
			}else{
				if(avenueLevel[a]  >= 4){
					Window.answer.setText("You cant buy houses any more");
				}else{
					Window.answer.setText("You cant buy  that many houses, you own " + avenueLevel[a]);
				}
			}
		}else{
			Window.answer.setText("You dont own that");
		}
	}
	
	public static void buyHotel(int i,int nOH, int a){//i player; a where house is being bought
		if(whoOwnsIt[a] == i){	
			if(nOH == 1 && avenueLevel[a] == 4){	
				for(int x = 0; x < avenue.length; x++){
					if(a == avenue[x]){
						playerMoney[i] -= nOH*costOfBuilding[a];
						Window.payment.setText("You bought " + nOH + " hotel for $" + nOH*costOfBuilding[a]); 
						avenueLevel[a] = 5;// nOH = number of houses
						break;
					}
				}
			}else{
				if(avenueLevel[a] != 4 && avenueLevel[a] != 5){
					Window.answer.setText("You dont own 4 houses for that propery");
				} else if(nOH != 1){
					Window.answer.setText("You only buy one hotel");
				}
			}
		}
	}
	
	public static int utilityMul = 1, railroadMul = 1;
	public static void chanceCards(int i){//7,22,36
		if(playerPosition[i] == 7 || playerPosition[i] == 22 || playerPosition[i] == 36){
			int r = (int)(16 * Math.random() + 1);
			String temp = "";
			if(r == 1){
				temp = "Advance to Go (Collect $200)";
				playerMoney[i] += 200;
				playerPosition[i] = 0;
			} else if(r == 2){
				temp  = "Advance to Illinois Ave. - If you pass Go, collect $200";
				if(playerPosition[i] > 24){
					playerMoney[i] += 200;
				}
				playerPosition[i] = 24;
			}else if(r == 3){
				temp = "Advance to St. Charles Place – If you pass Go, collect $200";
				if(playerPosition[i] > 11){
					playerMoney[i] += 200;
				}
				playerPosition[i] = 11;
			}else if(r == 4){
				temp = "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown. ";
				utilityMul = 10;
				if(playerPosition[i] == 7){
					playerPosition[i] = 12;
				}else if(playerPosition[i] == 22 || playerPosition[i] == 36){
					playerPosition[i] = 28;
				}
			}else if(r == 5){
				temp = "Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.";
				railroadMul = 2;
				if(playerPosition[i] == 7){
					playerPosition[i] = 5;
				}else if(playerPosition[i] == 22){
					playerPosition[i] = 25;
				}else if(playerPosition[i] == 36){
					playerPosition[i] = 35;	
				}
			}else if(r == 6){
				temp = "Bank pays you dividend of $50";
				playerMoney[i] += 50;
			}else if(r == 7){
				temp = "Get out of Jail Free";
				getOutOfJailFreeCard[i]++;
			}else if(r == 8){
				temp = "Go Back 3 Spaces";
				playerPosition[i] -= 3;
			}else if(r == 9){
				temp = "Go to Jail";
				playerPosition[i] = 30;
			}else if(r == 10){
				temp = "Make general repairs on all your property – For each house pay $25 – For each hotel $100";
				playerMoney[i] -= (numOfHousesOwned(i) * 25) + (numOfHotelsOwned(i) * 100 );
			}else if(r == 11){
				temp = "Pay poor tax of $15";
				playerMoney[i] -= 15;
			}else if(r == 12){
				temp = "Take a trip to Reading Railroad - If you pass Go, collect $200 ";
				if(playerPosition[i] > 5){
					playerMoney[i] += 200;
				}
				playerPosition[i] = 5;
			}else if(r == 13){
				temp = "Take a walk on the Boardwalk";
				playerPosition[i] = 39;
			}else if(r == 14){
				temp = "You have been elected Chairman of the Board – Pay each player $50 ";
				playerMoney[i] += 50*numberOfPlayers;
				for(int p = 0; p < numberOfPlayers-1; p++){
					if(i != p){
						playerMoney[p] -= 50;
					}
				}
			}else if(r == 15){
				temp = "Your building {and} loan matures – Collect $150 ";
				playerMoney[i] += 150;
			}else if(r == 16){
				temp = "You have won a crossword competition - Collect $100";
				playerMoney[i] += 100;
			}
			Window.card.setText(temp);
		}
	}
	
	public static void communityChestCards(int i){// 2,17,33
		if(playerPosition[i] == 2 || playerPosition[i] == 17 || playerPosition[i] == 33){
			int r = (int)(16 * Math.random() + 1);
			String temp = "";
			if(r == 1){
				temp = "Advance to Go (Collect $200)";
				playerMoney[i] += 200;
				playerPosition[i] = 0;
			}else if(r == 2){
				temp = "Bank error in your favor – Collect $200";
				playerMoney[i] += 200;
			}else if(r == 3){
				temp = "Doctor's fees {fee} - Pay $50 ";
				playerMoney[i] -= 50;
			}else if(r == 4){
				temp = "From sale of stock you get $50";
				playerMoney[i] += 50;
			}else if(r == 5){
				temp = "Get Out of Jail Free";
				getOutOfJailFreeCard[i]++;
			}else if(r == 6){
				temp = "Go to Jail";
				playerPosition[i] = 30;
			}else if(r == 7){
				temp = "Grand Opera Night {Opening} colloect 50 form ebery player";
				playerMoney[i] += 50*numberOfPlayers;
				for(int p = 0; p < numberOfPlayers; p++){
					if(i != p){
						playerMoney[p] -= 50;
					}
				}
			}else if(r == 8){
				temp = "Holiday {Xmas} Fund matures - Collect $100";
				playerMoney[i] += 100;
			}else if(r == 9){
				temp = "Income tax refund – Collect $20";
				playerMoney[i] += 20;
			}else if(r == 10){
				temp = "Life insurance matures – Collect $100";
				playerMoney[i] += 100;
			}else if(r == 11){
				temp = "Pay hospital fees of $100";
				playerMoney[i] -= 100;
			}else if(r == 12){
				temp = "Pay school fees {tax} of $150";
				playerMoney[i] -= 150;
			}else if(r == 13){
				temp = "Receive $25 consultancy fee";
				playerMoney[i] += 25;
			}else if(r == 14){
				temp = "You are assessed for street repairs – $40 per house – $115 per hotel";
				playerMoney[i] -= (numOfHousesOwned(i) * 40) + (numOfHotelsOwned(i) * 115 );
			}else if(r == 15){
				temp = "You have won second prize in a beauty contest";
				playerMoney[i] += 10;		
			}else if(r == 16){
				temp = "You inherit $100";
				playerMoney[i] += 100;		
			}
			Window.card.setText(temp);
		}
	}

}