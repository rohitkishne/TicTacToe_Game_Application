/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.WindowConstants;

/**
 *
 * @author dell
 */
public final class GUI extends JFrame implements ActionListener {
    JFrame window;
    JPanel title;
    JPanel game ;
    JPanel reloadgame;
    JPanel score;
    JPanel scoreH;
    JLabel scoreTitle;
    JLabel text;
    JButton[] button;
    JLabel person1;
    JLabel person2;
    JButton reload;
    JButton close;
    GUI()
    {
        title = new JPanel();
        game = new JPanel();
        reloadgame = new JPanel();
        score = new JPanel();
        scoreH = new JPanel();
        
        text = new JLabel();
        button = new JButton[9];
        scoreTitle = new JLabel();
        person1 = new JLabel();
        person2 = new JLabel();
        reload = new JButton("START THE GAME");
        close = new JButton("CLOSE"); 
        
        window = new JFrame("TicTacToe");
        Image icon = Toolkit.getDefaultToolkit().getImage("D:\\Java project\\TicTacToe\\image\\logo.png");
        window.setIconImage(icon);
        window.getContentPane().setBackground(Color.LIGHT_GRAY);
        window.setSize(800, 600);
        window.setLayout(new BorderLayout());
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TicTacToe();
    }
    int personXscore = 0;
    int personYscore = 0;
    boolean personXturn;
    
    public void TicTacToe(){
        //Title Panel --> Contains Name of the Application
        text.setBackground(Color.BLACK);
        text.setForeground(Color.red);
        text.setFont(new Font(Font.SANS_SERIF, Font.BOLD,50));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic Tac Toe");
        text.setOpaque(true);
        
        title.setLayout(new BorderLayout());
        title.setPreferredSize(new Dimension(800,70));
        title.add(text);
//        window.add(title, BorderLayout.NORTH);
        
        //Game Panel --> Contains Buttons and Space for Game 
        game.setPreferredSize(new Dimension(500, 460));
        game.setLayout(new GridLayout(3,3));
        game.setBackground(Color.DARK_GRAY);
        for(int i=0; i<9; i++)
        {
            button[i] = new JButton();
            game.add(button[i]);
            
            button[i].setFont(new Font(Font.DIALOG, Font.BOLD, 50));
            button[i].setBackground(Color.WHITE);
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }
//        window.add(game, BorderLayout.WEST);
        
        //Score Title Panel --> Update the person's Score

        scoreTitle.setText("SCORE");
        scoreTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        scoreTitle.setBackground(Color.LIGHT_GRAY);
        scoreTitle.setForeground(Color.YELLOW);
        scoreTitle.setHorizontalAlignment(JLabel.CENTER);
        scoreTitle.setOpaque(true);
        
        scoreH.setLayout(new BorderLayout());
//        scoreH.setPreferredSize(new Dimension(150,50));
        scoreH.add(scoreTitle, BorderLayout.NORTH);
       
         
        //Player Score Panel --> update player's scores
        score.setLayout(new GridLayout(2,1));
        score.setBackground(new Color(204,255,255));
        
        person1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        person1.setText("Player 1 : "+ personXscore);
        person1.setForeground(Color.red);
        person1.setHorizontalAlignment(JLabel.CENTER);
        
        person2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        person2.setText("Player 2 : "+ personYscore);
        person2.setForeground(Color.red);
        person2.setHorizontalAlignment(JLabel.CENTER);
        
        score.add(person1);
        score.add(person2);
        
        scoreH.add(score, BorderLayout.CENTER);
        
//        window.add(scoreH); 
        //Reload Game --> User can reload the game 
        reloadgame.setLayout(new BorderLayout());
        reloadgame.setBackground(Color.BLACK);
        reloadgame.setPreferredSize(new Dimension(800,50));
        
        reload.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        reload.setBackground(new Color(204,204,255));
        reload.setForeground(Color.blue);
        reload.setFocusable(false);
        reload.addActionListener(this);
        
        close.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.setFocusable(false);
        close.addActionListener(this);
       
        
        reloadgame.add(reload,BorderLayout.CENTER);
        reloadgame.add(close, BorderLayout.EAST);
        
        window.add(title, BorderLayout.NORTH);
        window.add(game, BorderLayout.WEST);
        window.add(scoreH);
        window.add(reloadgame, BorderLayout.SOUTH);

//        firstTurn();       
        
    }
    
    public void firstTurn(){
        try{
            Thread.sleep(1500);
        }
        catch(InterruptedException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        if(Math.random()<0.5)
        {
            personXturn = true;
            text.setText("Player 1 Turn");
        }
        else
        {
            personXturn = false;
            text.setText("Player 2 Turn");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
          for(int i=0; i<9; i++)
          {
              if(e.getSource() == button[i])
              {
                  if(personXturn)
                  {
                      if(" ".equals(button[i].getText()))
                      {
                          button[i].setBackground(Color.red);
                          button[i].setText("X");
                          personXturn = false;
                          text.setText("Player 1 Turn");
                          text.setForeground(Color.red);
                          check();
                      }
                  }
                 else
                  {
                      if(" ".equals(button[i].getText()))
                      {
                          button[i].setBackground(Color.BLUE);
                          button[i].setText("O");
                          personXturn = true;
                          text.setText("Player 2 Turn");
                          text.setForeground(Color.red);
                          check();
                      }
                  }
              }
          }
          if(e.getSource()==reload)
          {
              reload.setText("RELOAD TO NEW GAME");
              reload();
          }
          if(e.getSource()==close)
          {
              window.dispose();
          }
    }
    public void reload(){
        
        for(int i=0; i<9; i++)
        {
            button[i].setText(" ");
            button[i].setBackground(new Color(240, 240, 240));
            button[i].setEnabled(true);
        }
        firstTurn();
    }
    public void check(){
        if(
                "X".equals(button[0].getText()) &&
                "X".equals(button[1].getText()) && "X".equals(button[2].getText())
                )
        {
            xplayerwin(0,1,2);
        } else {
        }
        if(
                "X".equals(button[3].getText()) &&
                "X".equals(button[4].getText()) &&
                "X".equals(button[5].getText())
                )
        {
           xplayerwin(3,4,5);
        }
        if(
                "X".equals(button[6].getText()) &&
                "X".equals(button[7].getText()) &&
                "X".equals(button[8].getText())
                )
        {
           xplayerwin(6,7,8);
        }
        if(
                "X".equals(button[0].getText()) &&
                "X".equals(button[3].getText()) &&
                "X".equals(button[6].getText())
                )
        {
           xplayerwin(0,3,6);
        }
        if(
                "X".equals(button[1].getText()) &&
                "X".equals(button[4].getText()) &&
                "X".equals(button[7].getText())
                )
        {
           xplayerwin(1,4,7);
        }
        if(
                "X".equals(button[2].getText()) &&
                "X".equals(button[5].getText()) &&
                "X".equals(button[8].getText())
                )
        {
           xplayerwin(2,5,8);
        }
        if("X".equals(button[0].getText()) && "X".equals(button[4].getText()) && "X".equals(button[8].getText()))
        {
            xplayerwin(0,4,8);
        }
        if("X".equals(button[2].getText()) && "X".equals(button[4].getText()) && "X".equals(button[6].getText()))
        {
            xplayerwin(2,4,6);
        }
        
        // YPlayerWin
         if(
                "O".equals(button[0].getText()) &&
                 "O".equals(button[1].getText()) &&
                 "O".equals(button[2].getText())
                )
        {
           yplayerwin(0,1,2);
        }
        if(
                "O".equals(button[3].getText()) &&
                "O".equals(button[4].getText()) &&
                "O".equals(button[5].getText())
                )
        {
           yplayerwin(3,4,5);
        }
        if(
                "O".equals(button[6].getText()) &&
                "O".equals(button[7].getText()) &&
                "O".equals(button[8].getText())
                )
        {
           yplayerwin(6,7,8);
        }
        if(
                "O".equals(button[0].getText()) &&
                "O".equals(button[3].getText()) &&
                "O".equals(button[6].getText())
                )
        {
           yplayerwin(0,3,6);
        }
        if(
                "O".equals(button[1].getText()) &&
                "O".equals(button[4].getText()) &&
                "O".equals(button[7].getText())
                )
        {
           yplayerwin(1,4,7);
        }
        if(
                "O".equals(button[2].getText()) &&
                "O".equals(button[5].getText()) &&
                "O".equals(button[8].getText())
                )
        {
           yplayerwin(2,5,8);
        }
        if("O".equals(button[0].getText()) && "O".equals(button[4].getText()) && "O".equals(button[8].getText()))
        {
            yplayerwin(0,4,8);
        }
        if("O".equals(button[2].getText()) && "O".equals(button[4].getText()) && "O".equals(button[6].getText()))
        {
            yplayerwin(2,4,6);
        }
        
    }
    public void xplayerwin(int a, int b, int c ){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++)
        {
            button[i].setEnabled(false);
        }
        text.setText("PLAYER 1 WON THE GAME");
        personXscore++;
        person1.setText("Player 1  : "+ personXscore);
        
    }
    public void yplayerwin(int a, int b, int c ){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        
        for(int i=0; i<9; i++)
        {
            button[i].setEnabled(false);
        }
        text.setText("PLAYER 2 WON THE GAME");
        personYscore++;
        person2.setText("Player 2  : "+ personYscore);
    }
}
