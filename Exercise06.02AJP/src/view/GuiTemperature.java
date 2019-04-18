package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.Clock;
import model.Temperature;

public class GuiTemperature extends JFrame
{
   private JLabel labelTemp, labelClock;
   private JTextField textFieldTemp;
   private JButton buttonToCelcius;
   private JButton buttonToFahrenheit;
   
   // model classes
   private Temperature temp;
   private Clock clock;

   public GuiTemperature(Temperature temp, Clock clock)
   {
      super("Temperature conversion");
      this.temp = temp;
      this.clock = clock;
      
      createComponents();
      initializeComponents();
      registerEventHandlers();
      addComponentsToFrame();
   }

   private void createComponents()
   {
      labelClock = new JLabel("00:00:00");
      textFieldTemp = new JTextField(6);
      labelTemp = new JLabel("Temperature:");
      buttonToCelcius = new JButton("To Celcius");
      buttonToFahrenheit = new JButton("To Fahrenheit");
   }

   private void initializeComponents()
   {
      setSize(300, 120); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      showClock(clock.getCurrentTime());
   }

   private void registerEventHandlers()
   {
      ButtonHandler handler = new ButtonHandler(temp);
      buttonToCelcius.addActionListener(handler);
      buttonToFahrenheit.addActionListener(handler);
   }

   private void addComponentsToFrame()
   {
      JPanel panelDegree = new JPanel(new BorderLayout());
      panelDegree.add(labelTemp, BorderLayout.NORTH);
      panelDegree.add(textFieldTemp, BorderLayout.SOUTH);

      JPanel panelButtons = new JPanel(new BorderLayout(0, 5));
      panelButtons.add(buttonToCelcius, BorderLayout.NORTH);
      panelButtons.add(buttonToFahrenheit, BorderLayout.SOUTH);

      JPanel contentPane = new JPanel(new FlowLayout());
      contentPane.add(panelDegree);
      contentPane.add(panelButtons);
      contentPane.add(labelClock);

      setContentPane(contentPane);
   }

   public void showClock(String time)
   {
      
      labelClock.setText(time);
   }

   private class ButtonHandler implements ActionListener
   {
      private Temperature temp;
      
      public ButtonHandler(Temperature temp)
      {
         this.temp = temp;
      }
      
      public void actionPerformed(ActionEvent event)
      {
         String msg = textFieldTemp.getText();
         double temperature = 0;
         try
         {
            temperature = Double.parseDouble(msg);
         }
         catch (NumberFormatException e)
         {
            msg = "0";
         }
         
         if (event.getSource() == buttonToCelcius)
         {
            double t = temp.fahrenheitToCelcius(temperature);
            msg = String.format("%s Fah = %.2f Celcius", msg, t);
         }
         else if (event.getSource() == buttonToFahrenheit)
         {
            double t = temp.celciusToFahrenheit(temperature);
            msg = String.format("%s Celcius = %.2f Fah", msg, t);
         }
         JOptionPane.showMessageDialog(null, msg);
      }
   } // End of class ButtonHandler
} // End of class GuiTemperature
