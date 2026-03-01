import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level1CodingExam implements ActionListener {
JFrame frame= new JFrame("Color Teacher");
JPanel panel= new JPanel();
JButton button = new JButton();
JButton button1 = new JButton();
JButton button2 = new JButton();
JButton button3 = new JButton();

public void run(){
	frame.add(panel);
	panel.add(button);
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);

	frame.pack();
	frame.setVisible(true);

	button.setBackground(Color.green);
	button.setOpaque(true);
	button1.setBackground(Color.magenta);
	button1.setOpaque(true);
	
	button2.setBackground(Color.cyan);
	button2.setOpaque(true);
	
	button3.setBackground(Color.YELLOW);
	button3.setOpaque(true);
	
	button.addActionListener(this);
	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
@Override
public void actionPerformed(ActionEvent arg0) {
	JButton buttonPressed = (JButton) arg0.getSource();
	if(button == buttonPressed) {
		
		speak("green");
	}
	if(button1 == buttonPressed) {
		speak("magenta");
	}
	if(button2 == buttonPressed) {
		speak("cyan");
	}
	if(button3 == buttonPressed) {
		speak("yellow");
	}
}
static void speak(String words) {
    if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
        String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                + words + "');\"";
        try {
            Runtime.getRuntime().exec( cmd ).waitFor();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    } else {
        try {
            Runtime.getRuntime().exec( "say -v Yuna " + words ).waitFor();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
}
