package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame  implements ActionListener 
{
	public static JButton button1, button2, button3, button4;
	public static JLabel info,payment,buy,sell, player1Info, player2Info, player3Info, player4Info, choices, dice1, dice2, tester, card;
	public static JTextField answer;
	int w = 1000, h = w;
	String title = "Monopoly";
	Display game = new Display();
	public Window(){
		game.setPreferredSize(new Dimension(w, h));
		game.setMaximumSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));
		
		JFrame frame = new JFrame(title);
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		
		button1.setBounds(200, 500 - 10, 80, 30);
		button2.setBounds(270, 500 - 10, 80, 30);
		button3.setBounds(340, 500 - 10, 80, 30);
		button4.setBounds(410, 500 - 10, 80, 30);
		
		
		button1.addActionListener(this);button2.addActionListener(this);button3.addActionListener(this);button4.addActionListener(this);     
		frame.add(button1); frame.add(button2); frame.add(button3); frame.add(button4);
		
		info =  new JLabel();frame.add(info);
		player1Info =  new JLabel();frame.add(player1Info);
		player2Info =  new JLabel();frame.add(player2Info);
		player3Info =  new JLabel();frame.add(player3Info);
		player4Info =  new JLabel();frame.add(player4Info);
		dice1 = new JLabel("   0");frame.add(dice1);
		dice1.setBounds(250, 550, 30, 30);
		dice2 = new JLabel("   0");frame.add(dice2);
		dice2.setBounds(300, 550, 30, 30);
		choices = new JLabel();frame.add(choices);
		choices.setBounds(200, 450, 500, 20);
		
		tester =  new JLabel("");frame.add(tester);
		tester.setBounds(200, 600, 500, 20);
		
		card = new JLabel("");frame.add(card);
		card.setBounds(200, 650, 500, 20);
		
		payment = new JLabel("");frame.add(payment);
		payment.setBounds(200, 625, 500, 20);
		
		buy = new JLabel(" #(loc.) buy #(of) house/hotel");frame.add(buy);
		buy.setBounds(585, 455, 200, 20);
		sell = new JLabel("sell #");frame.add(sell);
		sell.setBounds(585, 475, 100, 20);
		
		
		answer = new JTextField(11);frame.add(answer);
		answer.setBounds(585, 495, 200, 20);
		answer.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		    	String temp = answer.getText();
		    	if(temp.indexOf("sell") > -1){
		    		int loc = Integer.valueOf(temp.trim().substring(5, temp.length()));
		    	    if(Player.player == Player.whoOwnsIt[loc]){
		    	    	Player.whoOwnsIt[loc] = 4;
		    	    	Player.playerMoney[Player.player] += Player.getMortgageValue(loc);
		    	    	payment.setText("You sold " + Player.getPositionL(loc) + " for $" + Player.getMortgageValue(loc));
		    	    	Player.avenueLevel[loc] = 0;
				    	Player.rent();
		    	    } else {
		    	    	answer.setText("You dont own that.");
		    	    }
		    	}else if(temp.indexOf("buy") > -1){
		    		int loc = Integer.valueOf(temp.substring(0 , temp.indexOf("buy") - 1));
		    		if(temp.indexOf("house") > -1){
		    			int num = Integer.valueOf(temp.substring(temp.indexOf("buy") + 4, temp.length() - 6));
		    			Player.buyHouse(Player.player, num, loc);
				    	Player.rent();
		    		}else if(temp.indexOf("hotel") > -1){
		    			Player.buyHotel(Player.player, 1, loc);
		    		}
		    	}else if(temp.indexOf("go to") > -1){
		    		int loc = Integer.valueOf(temp.substring(6, temp.length()));
		    		//Player.playerPosition[Player.player] = loc;
		    		//Player.tester(Player.player, 0 ,0);
		    		Player.tester = loc;
		    	}
		    }
		});
		
		sell.setVisible(false);
		buy.setVisible(false);
		answer.setVisible(false);
		
		
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		if (src == button1) {
			Player.button[0] = true;
		} else if (src == button2) {
			Player.button[1] = true;
		}else if (src == button3) {
			Player.button[2] = true;
		}else if (src == button4) {
			Player.button[3] = true;
		}
		
	 }
}