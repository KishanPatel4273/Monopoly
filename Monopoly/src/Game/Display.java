package Game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Display extends Canvas implements Runnable {

	private static final long serialVersionUID = 992667339233932903L;
	
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	
	
	public synchronized void start(){
		if(running)//fail save method
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	
	public void run() {
		for(int i = 0;i < Player.numberOfPlayers-1;i++){
			while(running && Player.endGame()){
				if(!Player.run){
					running = false;
				}
				Player.player = i;
				render();
				if(i > Player.numberOfPlayers -1){i = 0;}
				Player.getChoices(i, Player.reRoll, Player.buy);
//roll
				if(Player.button[0] && Player.reRoll && Player.playerInJail[i] != 0 && !Player.buy){
					Player.resetButtons();
					Player.clearButtons();
					Player.playerPosition[i] += Player.roll();
					//Player.playerPosition[i] = Player.tester;
					Player.tester(i, Player.dice1, Player.dice2);
					render();
//buy
					if(1 < Player.getCost(i) && Player.whoOwnsIt[Player.playerPosition[i]] == 4 ){//sees if you can but it
						render();
						Player.buy = true;
						Player.getChoices(i, Player.reRoll, Player.buy);
					}

					if(Player.snakeEyes){
						Player.reRoll = true;
					}else {
						Player.reRoll = false;
					}
					
//roll					
//buy
				} else if (Player.button[0] && Player.buy && Player.whoOwnsIt[Player.playerPosition[i]] == 4){
					//if they say yes to buy property
					Player.playerMoney[i] -= Player.getCost(i);
					Player.addProperty(i);
					Player.resetButtons();
					Player.clearButtons();
					Player.buy = false;
//buy
//jail
				} else if(Player.playerInJail[i] == 0 && Player.button[0] && Player.numberOfTurnsInJail[i] < 4){//roll to get out out of jail
					Player.resetButtons();
					Player.roll();
					if(Player.dice1 == Player.dice2){
						Player.playerInJail[i] += 1;
						Player.numberOfTurnsInJail[i] = 0;
						Player.playerPosition[i] += Player.dice1 + Player.dice2;
						Player.reRoll = false;
					}else{
						Player.numberOfTurnsInJail[i] -= 1;
						if(Player.numberOfTurnsInJail[i] == 0){
							Player.playerInJail[i] += 1;
							Player.numberOfTurnsInJail[i] = 0;
							Player.playerMoney[i] -= 50;
						}
						Player.buy = false;
						Player.reRoll = true;
						Player.resetButtons();
						Player.clearButtons();
						i++;
					}
//Jail
//buy
				}else if (Player.button[1] && Player.buy){
					Player.resetButtons();
					Player.clearButtons();
					Player.buy = false;
//buy
//jail
				} else if (Player.playerInJail[i] == 0 && Player.button[1]){//pay 50 to get out of jail
					Player.resetButtons();
					Player.clearButtons();
					Player.playerMoney[i] -= 50;
					Player.playerInJail[i] += 1;
					Player.numberOfTurnsInJail[i] = 0;
					Player.reRoll = false;
//Jail
//jail
				} else if(Player.playerInJail[i] == 0 && Player.button[3]){// ends turn in jail
					Player.resetButtons();
					Player.numberOfTurnsInJail[i] -= 1;
					if(Player.numberOfTurnsInJail[i] == 0){
						Player.playerInJail[i] += 1;
						Player.numberOfTurnsInJail[i] = 0;
						Player.playerMoney[i] -= 50;
					}
					Player.clearButtons();
					Player.buy = false;
					Player.reRoll = true;
					i++;
				}else if(Player.getOutOfJailFreeCard[i] > 0 && Player.button[2]){	
					Player.resetButtons();
					Player.clearButtons();
					Player.playerInJail[i] += 1;
					Player.numberOfTurnsInJail[i] = 0;
					Player.getOutOfJailFreeCard[i] -= 1;
					Player.reRoll = false;
//jail
				}else if(Player.button[0] && !Player.reRoll){
					Player.resetButtons();
					Player.clearButtons();
					Player.reRoll = true;
					Player.buy = false;
					i++;
				} 
			}
		}
	}
	
	
	public Image background = new ImageIcon("res/MonopolyBoard.png").getImage();
	private void render()//renders graphics  this. refers to canvas class
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);//number of image ready to go
			return; //take you out of method 
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		//draw here
		Player.renderOwners(g);
		g.drawImage(background, 0, 0, 1000, 1000, null);
		Player.renderPlayer(g, Player.numberOfPlayers);		
		Player.renderPlayerInfo(g, Player.numberOfPlayers);
		g.setColor(Color.blue);
		g.fillRect(249, 549, 32, 32);
		g.fillRect(299, 549, 32, 32);
		
		Player.renderHouse(g);
		Player.renderHotel(g);

		//Window.answer.setVisible(true);
		//here you can change rules for buying and selling houses/ prop
		if(Player.getNumberOfProperty(Player.player) > 0){
			Window.sell.setVisible(true);
			Window.buy.setVisible(true);
			Window.answer.setVisible(true);
		}else{
			Window.sell.setVisible(false);
			Window.buy.setVisible(false);
			Window.answer.setVisible(false);
		}
		
		//end
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many Player do you have?");
		Player.numberOfPlayers = Integer.valueOf(in.nextLine());
		int n = 1;
		for(int x = 0; x < Player.numberOfPlayers; x++){
			System.out.println("Whats player" + n++ + "'s name?");
			Player.playerNames[x] = in.nextLine();
		}
		new Window();  
	}

}