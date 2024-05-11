import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class IDGenerator extends JFrame {
    private JPanel mainPanel;
    private JTextField yearField;
    private JTextField monthField;
    private JTextField dayField;
    private JTextField genderField;
    private JButton generateButton;
    private JTextField idField;

    public static void main(String[] args){
        new IDGenerator();
    }

    public IDGenerator(){
        setTitle("South African ID Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2));

        yearField = new JTextField();
        monthField = new JTextField();
        dayField = new JTextField();
        genderField = new JTextField();
        generateButton = new JButton("Generate ID");
        idField = new JTextField();

        mainPanel.add(new JLabel("Year:"));
        mainPanel.add(yearField);
        mainPanel.add(new JLabel("Month:"));
        mainPanel.add(monthField);
        mainPanel.add(new JLabel("Day:"));
        mainPanel.add(dayField);
        mainPanel.add(new JLabel("Gender:"));
        mainPanel.add(genderField);
        mainPanel.add(generateButton);
        mainPanel.add(idField);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(yearField.getText());
                    int month = Integer.parseInt(monthField.getText());
                    int day = Integer.parseInt(dayField.getText());
                    String gender = genderField.getText();
                    generateID(year, month, day, gender);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter valid integer values for year, month, and day.");
                }
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    private void generateID(int year, int month, int day, String gender){
        String idNum;
        String yearString = String.format("%02d", year % 100);
        String monthString = String.format("%02d", month);
        String dayString = String.format("%02d", day);
        idNum = yearString + monthString + dayString;

        int minRange = (gender.equalsIgnoreCase("Female")) ? 0 : 5000;
        int maxRange = (gender.equalsIgnoreCase("Female")) ? 4999 : 9999;

        Random random = new Random();
        int genderDigits = random.nextInt(maxRange - minRange + 1) + minRange;
        String genderString = String.format("%04d", genderDigits);

        int citizenshipDigit = random.nextInt(2);
        int a = random.nextInt(2) + 8;

        idNum = idNum + genderString + citizenshipDigit + a;

        int[] factors = {1,2,1,2,1,2,1,2,1,2,1,2,1};
        int sum = 0;
        for(int i = 0; i < idNum.length(); i++){
            int digit = Character.getNumericValue(idNum.charAt(i));
            digit *= factors[i % factors.length];
            if(digit > 9){
                digit = digit / 10 + digit % 10;
            }
            sum += digit;
        }
        int checksumDigit = 10 - (sum % 10);
        idNum = idNum + (checksumDigit % 10);

        idField.setText(idNum);
    }
}
