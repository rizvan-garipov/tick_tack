import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class tick_tack {
    private JPanel panel;
    private List<myButton> buttonList;

    public tick_tack(){
        panel = new JPanel();
        buttonList = new ArrayList<myButton>();
        for(int i = 1; i<4; i++){
            for(int j = 1; j < 4; j++){
                myButton button = new myButton(i, j);
                button.addActionListener(new pressToButton());
                button.setFont(new Font("myFont", Font.BOLD, 34));
                button.setForeground(Color.RED);
                        panel.add(button);
                        buttonList.add(button);
            }
        }

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width0 = dimension.width;
        int height0 = dimension.height;
        int width = 600;
        int height = 600;
        int xLocation = (width0 - width) / 2;
        int yLocation = (height0 - height) / 2;

        GridLayout layout = new GridLayout(3,3);
        panel.setLayout(layout);
        JFrame frame = new JFrame("TickTack");
        frame.setBounds(xLocation,yLocation,width, height );
        frame.setContentPane(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    protected class pressToButton implements ActionListener {
            @Override
        public void actionPerformed(ActionEvent e) {
                 myButton button = (myButton) e.getSource();
                button.setBackground(Color.CYAN);
                 button.setText("X");
                 button.setVisit(true);
        }
    }
}
