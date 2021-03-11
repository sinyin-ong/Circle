//DPJ5531 Final Project
//Student Name  : Ong Sin Yin
//Student ID    : 1181203333
//Class Section : TT3V

package circle;

public class Main
{
    public static void main(String[]args)
    {
        Mainframe frame = new Mainframe();

        //Action occur when I click on Redraw Circles Button
        frame.redrawButton.addActionListener(redrawEvent -> { //Using lambda because the anonymous class has one method only

            //If click the redraw button
            if (redrawEvent.getSource() == frame.redrawButton) {

                //Get data from input text field
                String sx1 = frame.inputX1.getText();
                String sy1 = frame.inputY1.getText();
                String sr1 = frame.inputR1.getText();
                String sx2 = frame.inputX2.getText();
                String sy2 = frame.inputY2.getText();
                String sr2 = frame.inputR2.getText();

                int x1, y1, r1, x2, y2, r2;

                //If input text field is empty, I set a default value and display  it
                if (sx1.isEmpty())
                {
                    x1 = 50;
                    frame.inputX1.setText(x1+"");
                }
                else
                {
                    x1 = Integer.parseInt(sx1.trim()); //Convert string value to integer value and remove the empty space
                }

                if (sy1.isEmpty())
                {
                    y1 = 50;
                    frame.inputY1.setText(y1+"");
                }
                else
                {
                    y1 = Integer.parseInt(sy1.trim());
                }

                if (sr1.isEmpty())
                {
                    r1 = 50;
                    frame.inputR1.setText(r1+"");
                }
                else
                {
                    r1 = Integer.parseInt(sr1.trim());
                }

                if (sx2.isEmpty())
                {
                    x2 = 100;
                    frame.inputX2.setText(x2+"");
                }
                else
                {
                    x2 = Integer.parseInt(sx2.trim());
                }

                if (sy2.isEmpty())
                {
                    y2 = 100;
                    frame.inputY2.setText(y2+"");
                }
                else
                {
                    y2 = Integer.parseInt(sy2.trim());
                }

                if (sr2.isEmpty())
                {
                    r2 = 50;
                    frame.inputR2.setText(r2+"");
                }
                else
                {
                    r2 = Integer.parseInt(sr2.trim());
                }

                //Repaint circle panel
                frame.circlePanel.removeAll();
                frame.circlePanel.repaint();
                frame.circlePanel.setLayout(null);

                //Set circles properties
                frame.setCircle1(x1, y1, r1, r2);
                frame.setCircle2(x2, y2, r1, r2);

                frame.checkIntersect(r1, r2);
            }
        });
    }
}