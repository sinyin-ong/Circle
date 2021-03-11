//DPJ5531 Final Project
//Student Name  : Ong Sin Yin
//Student ID    : 1181203333
//Class Section : TT3V

package circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mainframe extends JFrame
{
    Point pressedLocation;
    Point draggedLocation;

    int widthC1, widthC2;
    drawCircle circle1, circle2; //Declare 2 objects to draw 2 circles

    JFrame f = new JFrame("Circle Generator");

    JPanel titlePanel = new JPanel();
    JPanel circlePanel = new JPanel();
    JPanel valueWrapperPanel = new JPanel();
    JPanel valuePanel = new JPanel();
    JPanel valueWrapperWestPanel = new JPanel();
    JPanel valueWestPanel = new JPanel();
    JPanel valueWrapperEastPanel = new JPanel();
    JPanel valueEastPanel = new JPanel();

    JLabel title1Label = new JLabel("Two circles intersect?");
    JLabel title2Label = new JLabel("Yes");
    JLabel titleCircle1 = new JLabel("Enter circle 1 info: ");
    JLabel titleCircle2 = new JLabel("Enter circle 2 info: ");
    JLabel titleX1 = new JLabel("Center x:");
    JLabel titleX2 = new JLabel("Center x:");
    JLabel titleY1 = new JLabel("Center y:");
    JLabel titleY2 = new JLabel("Center y:");
    JLabel titleR1 = new JLabel("Radius:");
    JLabel titleR2 = new JLabel("Radius:");

    JTextField inputX1 = new JTextField();
    JTextField inputY1 = new JTextField();
    JTextField inputR1 = new JTextField();
    JTextField inputX2 = new JTextField();
    JTextField inputY2 = new JTextField();
    JTextField inputR2 = new JTextField();

    JButton redrawButton = new JButton("Redraw Circles");

    Mainframe()
    {
        //Frame
        f.setSize(600,600);
        f.setTitle("Circle Generator");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);

        //Intersect Title
        titlePanel.setPreferredSize(new Dimension(600,50));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        titlePanel.add(title1Label);
        titlePanel.add(title2Label);
        title1Label.setFont(new Font("TimesRoman", Font.BOLD,17));
        title2Label.setFont(new Font("TimesRoman", Font.BOLD,17));

        //Panel to draw circles
        circlePanel.setLayout(null);
        circlePanel.setPreferredSize(new Dimension(600,200));
        circle1 = setCircle1(50,50,50,50);    //Object to draw circle 1
        circle2 = setCircle2(100,100,50,50);  //Object to draw circle 2
        circlePanel.setVisible(true);

        //Bottom panel
        valueWrapperPanel.setPreferredSize(new Dimension(600,300));
        valueWrapperPanel.setLayout(new BorderLayout());
        valueWrapperPanel.add(valuePanel, BorderLayout.NORTH);

        valuePanel.setPreferredSize(new Dimension(530,300));
        valuePanel.setBorder(BorderFactory.createEmptyBorder(35,35,35,35));
        valuePanel.setLayout(new BorderLayout());
        valuePanel.add(valueWrapperWestPanel, BorderLayout.WEST);
        valuePanel.add(valueWrapperEastPanel, BorderLayout.EAST);

        //Circle 1 and 2 info panel
        valueWrapperWestPanel.setPreferredSize(new Dimension(250,200));
        valueWrapperEastPanel.setPreferredSize(new Dimension(250,200));
        valueWrapperWestPanel.setLayout(new BorderLayout());
        valueWrapperEastPanel.setLayout(new BorderLayout());
        valueWrapperWestPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        valueWrapperEastPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        valueWrapperWestPanel.add(titleCircle1, BorderLayout.NORTH);
        valueWrapperWestPanel.add(valueWestPanel, BorderLayout.CENTER);
        valueWrapperEastPanel.add(titleCircle2, BorderLayout.NORTH);
        valueWrapperEastPanel.add(valueEastPanel, BorderLayout.CENTER);

        //Input text field for circle 1
        valueWestPanel.setLayout(new GridLayout(3,2));
        valueWestPanel.add(titleX1);
        valueWestPanel.add(inputX1);
        valueWestPanel.add(titleY1);
        valueWestPanel.add(inputY1);
        valueWestPanel.add(titleR1);
        valueWestPanel.add(inputR1);

        //Input text field for circle 2
        valueEastPanel.setLayout(new GridLayout(3,2));
        valueEastPanel.add(titleX2);
        valueEastPanel.add(inputX2);
        valueEastPanel.add(titleY2);
        valueEastPanel.add(inputY2);
        valueEastPanel.add(titleR2);
        valueEastPanel.add(inputR2);

        //Info title font
        titleCircle1.setFont(new Font("TimesRoman", Font.PLAIN,16));
        titleX1.setFont(new Font("TimesRoman", Font.PLAIN,16));
        titleY1.setFont(new Font("TimesRoman", Font.PLAIN,16));
        titleR1.setFont(new Font("TimesRoman", Font.PLAIN,16));

        titleCircle2.setFont(new Font("TimesRoman", Font.PLAIN,16));
        titleX2.setFont(new Font("TimesRoman", Font.PLAIN,16));
        titleY2.setFont(new Font("TimesRoman", Font.PLAIN,16));
        titleR2.setFont(new Font("TimesRoman", Font.PLAIN,16));

        //Add redraw button
        valuePanel.add(redrawButton, BorderLayout.SOUTH);

        f.setLayout(new BorderLayout());
        f.add(titlePanel, BorderLayout.NORTH);
        f.add(circlePanel, BorderLayout.CENTER);
        f.add(valueWrapperPanel, BorderLayout.SOUTH);
    }

    //Set the properties of circle 1
    public drawCircle setCircle1(int x, int y, int r1, int r2)
    {
        widthC1 = r1*2;
        circle1 = new drawCircle(widthC1);
        circlePanel.add(circle1);
        circle1Listener(circle1, r1, r2);
        setCircleLocation(circle1, x, y, r1);

        return circle1;
    }

    //Set the properties of circle 1
    public drawCircle setCircle2(int x, int y, int r1, int r2)
    {
        widthC2 = r2*2;
        circle2 = new drawCircle(widthC2);
        circlePanel.add(circle2);
        circle2Listener(circle2, r1, r2);
        setCircleLocation(circle2, x, y, r2);

        return circle2;
    }

    //Set the location of circle
    public void setCircleLocation(drawCircle circle, int x, int y, int r)
    {
        circlePanel.setLayout(null);
        circle.setLocation(x-r, y-r);
    }

    //Function of calling mousePressed and mouseDragged listener for circle 1
    public void circle1Listener(drawCircle circle1, int r1, int r2)
    {
        circle1.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent location1)
            {
                pressedLocation = location1.getPoint();
            }
        });

        circle1.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent location1)
            {
                boolean draggingCircle1 = false;

                if(location1.getSource() == circle1)
                {
                    draggingCircle1 = true;
                }
                draggedLocation = location1.getLocationOnScreen();
                System.out.println("\nScreen location C1        : " + draggedLocation); //Test output
                System.out.println("Mouse pressed location C1 : "+pressedLocation); //Test output

                Point position1 = drag(draggingCircle1, false, r1, r2);
                circle1.setLocation(position1);
                System.out.println("Draw position C1          : "+position1); //Test output

                checkIntersect(r1, r2);
            }
        });
    }

    //Function of calling mousePressed and mouseDragged listener for circle 2
    public void circle2Listener(drawCircle circle2, int r1, int r2)
    {
        circle2.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent location2)
            {
                pressedLocation = location2.getPoint();
            }
        });

        circle2.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent location2)
            {
                boolean draggingCircle2 = false;

                if(location2.getSource() == circle2)
                {
                    draggingCircle2 = true;
                }
                draggedLocation = location2.getLocationOnScreen();
                System.out.println("\nScreen location C2        : "+draggedLocation); //Test output
                System.out.println("Mouse pressed location C2 : "+pressedLocation); //Test output

                Point position2 = drag(false, draggingCircle2, r1, r2);
                circle2.setLocation(position2);
                System.out.println("Draw position C2          : "+position2); //Test output

                checkIntersect(r1, r2);
            }
        });
    }

    //Function to calculate the point located after we dragged the circles
    public Point drag(boolean draggingCircle1, boolean draggingCircle2, int r1, int r2)
    {
        //Get the location of frame, pressed and dragged
        Point frameLocation = f.getLocationOnScreen();
        System.out.println("Frame location            : " +frameLocation);  //Test output

        double frameLocationX = frameLocation.getX();
        double frameLocationY = frameLocation.getY();

        double draggedLocationX = draggedLocation.getX();
        double draggedLocationY = draggedLocation.getY();
        double pressedLocationX = pressedLocation.getX();
        double pressedLocationY = pressedLocation.getY();

        int pointX = (int) (draggedLocationX - pressedLocationX - frameLocationX);
        int pointY = (int) (draggedLocationY - pressedLocationY - frameLocationY);

        //Set the limit of the moving area for circle 2
        if(pointX > 600)
        { pointX = 600; }

        if(pointY > 250)
        { pointY = 250; }

        //Set the point of circle 2
        Point position = new Point((pointX), (pointY-70));
        int newY = pointY-70;

        //Update the new point value to text field
        if(draggingCircle1)
        {
            inputX1.setText((pointX + r1) + "");
            inputY1.setText((newY + r1) + "");
            inputR1.setText(r1 + "");
        }
        else if(draggingCircle2)
        {
            inputX2.setText((pointX + r2) + "");
            inputY2.setText((newY + r2) + "");
            inputR2.setText(r2 + "");
        }

        return position;
    }

    //Function to check the intersect of 2 circles
    public void checkIntersect(int r1, int r2)
    {
        //Determine the center point of 2 circles
        Point centerPointC1 = circle1.getLocation();
        Point centerPointC2 = circle2.getLocation();
        int cx1 = (int) (centerPointC1.getX()+r1);
        int cx2 = (int) (centerPointC2.getX()+r2);
        int cy1 = (int) (centerPointC1.getY()+r1);
        int cy2 = (int) (centerPointC2.getY()+r2);

        //Calculate distance between both circle center points
        int dx = cx2 - cx1;
        int dy = cy2 - cy1;
        int distance = (int)(Math.sqrt((dy*dy)+(dx*dx)));

        System.out.println("Center x1: "+cx1);  //Test output
        System.out.println("Center y1: "+cy1);  //Test output
        System.out.println("Center x2: "+cx2);  //Test output
        System.out.println("Center y2: "+cy2);  //Test output

        //Determine whether the circumference of circles intersect to each other
        if(distance > (r1+r2))
        {
            title2Label.setText("No");
        }
        else if(distance < Math.abs(r1 - r2))
        {
            title2Label.setText("No");
        }
        else
        {
            title2Label.setText("Yes");
            System.out.println("Intersect!");  //Test output
        }
    }
}