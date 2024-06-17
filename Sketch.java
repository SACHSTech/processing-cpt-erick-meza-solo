import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
import java.util.Random;

public class Sketch extends PApplet {

  // Initializes variables
  PImage imgCenterstage;
  PImage imgCenterstageLogo;
  PImage imgFTCRobotOne;
  PImage imgFTCRobotTwo;
  PImage imgGreenLoadedRobotOne;
  PImage imgPinkLoadedRobotOne;
  PImage imgOrangeLoadedRobotOne;
  PImage imgYellowLoadedRobotOne;
  PImage imgGreenLoadedRobotTwo;
  PImage imgPinkLoadedRobotTwo;
  PImage imgOrangeLoadedRobotTwo;
  PImage imgYellowLoadedRobotTwo;
  PImage imgYellowPixel;
  PImage imgGreenPixel;
  PImage imgPinkPixel;
  PImage imgOrangePixel;
  PImage img000Timer;
  PImage img050Timer;
  PImage img100Timer;
  PImage img150Timer;
  PImage img200Timer;
  PImage img250Timer;
  PImage imgWinnerBlue;
  PImage imgWinnerRed;
  int[] intTime = new int[1];
  boolean[] blnHideOptions = new boolean[3];
  boolean[] blnMapSelection = new boolean[3];
  boolean[] blnShowRobot = { false, false, false, false };
  boolean[] blnElements = { true, false, false, false, false, false };
  int[] intMovement = { 20, -20 };
  int intRobotOneX = 20;
  int intRobotOneY = 300;
  int intRobotTwoX = 420;
  int intRobotTwoY = 300;
  int intElementX = 204;
  int intElementY = 650;
  int intPlayerOneScore = 0;
  int intPlayerTwoScore = 0;
  int intColour = 0;
  float fltMinute = 0;
  int intSecond = 0;
  float fltTimeDisplacement = 0;
  Random randColour = new Random();
  PFont textFont;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(900, 700);
  }

  /**
   * Called once at the beginning of execution. Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {

    // Sets the background
    background(255, 255, 255);

    // Loads each image within the program
    imgCenterstage = loadImage("Screen Images/Centerstage.png");
    imgCenterstageLogo = loadImage("Screen Images/Centerstage_Logo.png");
    imgFTCRobotOne = loadImage("Robots/FTCRobotOne.png");
    imgFTCRobotTwo = loadImage("Robots/FTCRobotTwo.png");
    imgGreenLoadedRobotOne = loadImage("Loaded Robots/RobotOne (Green).png");
    imgPinkLoadedRobotOne = loadImage("Loaded Robots/RobotOne (Pink).png");
    imgOrangeLoadedRobotOne = loadImage("Loaded Robots/RobotOne (Orange).png");
    imgYellowLoadedRobotOne = loadImage("Loaded Robots/RobotOne (Yellow).png");
    imgGreenLoadedRobotTwo = loadImage("Loaded Robots/RobotTwo (Green).png");
    imgPinkLoadedRobotTwo = loadImage("Loaded Robots/RobotTwo (Pink).png");
    imgOrangeLoadedRobotTwo = loadImage("Loaded Robots/RobotTwo (Orange).png");
    imgYellowLoadedRobotTwo = loadImage("Loaded Robots/RobotTwo (Yellow).png");
    imgYellowPixel = loadImage("Game_Elements/Pixel (Yellow).png");
    imgGreenPixel = loadImage("Game_Elements/Pixel (Green).png");
    imgPinkPixel = loadImage("Game_Elements/Pixel (Pink).png");
    imgOrangePixel = loadImage("Game_Elements/Pixel (Orange).png");
    img000Timer = loadImage("Timer/Timer (0).png");
    img050Timer = loadImage("Timer/Timer (0.5).png");
    img100Timer = loadImage("Timer/Timer (1).png");
    img150Timer = loadImage("Timer/Timer (1.5).png");
    img200Timer = loadImage("Timer/Timer (2).png");
    img250Timer = loadImage("Timer/Timer (2.5).png");
    imgWinnerBlue = loadImage("Screen Images/Blue Wins.png");
    imgWinnerRed = loadImage("Screen Images/Red Wins.png");


    // Resizes each image
    imgCenterstage.resize(width, height);
    imgCenterstageLogo.resize(width, height);
    imgFTCRobotOne.resize(175, 175);
    imgFTCRobotTwo.resize(175, 175);
    imgGreenLoadedRobotOne.resize(175, 175);
    imgPinkLoadedRobotOne.resize(175, 175);
    imgOrangeLoadedRobotOne.resize(175, 175);
    imgYellowLoadedRobotOne.resize(175, 175);
    imgGreenLoadedRobotTwo.resize(175, 175);
    imgPinkLoadedRobotTwo.resize(175, 175);
    imgOrangeLoadedRobotTwo.resize(175, 175);
    imgYellowLoadedRobotTwo.resize(175, 175);
    imgYellowPixel.resize(40, 40);
    imgGreenPixel.resize(40, 40);
    imgPinkPixel.resize(40, 40);
    imgOrangePixel.resize(40, 40);
    img000Timer.resize(120, 80);
    img050Timer.resize(120, 80);
    img100Timer.resize(120, 80);
    img150Timer.resize(120, 80);
    img200Timer.resize(120, 80);
    img250Timer.resize(120, 80);
    imgWinnerBlue.resize(width, height);
    imgWinnerRed.resize(width, height);

    // Outputs all logos
    image(imgCenterstageLogo, 0, 0);

    // Outputs an introduction text
    textFont = createFont("Poor Richard", 40);
    fill(255, 255, 255);
    textSize(30);
    textAlign(CENTER);
    text("CLICK THE SCREEN TO BEGIN", width / 2, 650);

    // Sets the title of the screen
    surface.setTitle("Erick M - ICS3U1 CPT");

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // Creates a variable to track the time elapsed
    int intMillis = millis();

    // Calls the map selection method
    mapSelection();

    // Creates a conditional selective algorithm to check if the game has begun
    if (blnMapSelection[0] == false){

      // Sets the value of intTime array to the current time
      intTime[0] = millis();
    }

    // Creates a conditional selective algorithm to check which map has been chosen
    if (blnMapSelection[0] == true) {

      
      // Displays the map
      image(imgCenterstage, 0, 0);

      // Outputs the robot
      blnShowRobot[0] = true;
      blnShowRobot[2] = true;
      
      // Creates a variable to store the time starting when the game starts
      fltTimeDisplacement = intMillis - intTime[0];
      
      // Calls the timeCheck() method to check delta time
      timeCheck();
        

      // Creates a conditional selective algorithm to output game elements
      if (blnElements[0] == true || blnElements[1] == true || blnElements[2] == true || blnElements[3] == true || blnElements[4] == true || blnElements[5] == true) {

        // Creates a conditional selective algorithm to check the colour of the game element
        if (intColour == 0) {

          // Outputs a Green Pixel
          image(imgGreenPixel, intElementX, intElementY);

        } else if (intColour == 1) {

          // Outputs a Yellow Pixel
          image(imgYellowPixel, intElementX, intElementY);

        } else if (intColour == 2) {

          // Outputs a Pink Pixel
          image(imgPinkPixel, intElementX, intElementY);

        } else if (intColour == 3) {

          // Outputs a White Pixel
          image(imgOrangePixel, intElementX, intElementY);

        }

      }

      // Calls the collisionDetection() method to check if objects have collided
      collisionDetection();

      // Creates a conditional selective algorithm to output robot one depending if the pixel is intaked or not
      if (blnShowRobot[0] == true) {

        // Outputs the robot with no pixel
        image(imgFTCRobotOne, intRobotOneX, intRobotOneY);

      } else if (blnShowRobot[0] == false && blnShowRobot[1] == true) {

        // Creates a conditional selective algorithm to check the colour of the intaked pixel
        if (intColour == 0) {

          // Outputs the robot with a green pixel
          image(imgGreenLoadedRobotOne, intRobotOneX, intRobotOneY);

        } else if (intColour == 1) {

          // Outputs the robot with a yellow pixel
          image(imgYellowLoadedRobotOne, intRobotOneX, intRobotOneY);

        } else if (intColour == 2) {

          // Outputs the robot with a pink pixel
          image(imgPinkLoadedRobotOne, intRobotOneX, intRobotOneY);

        } else if (intColour == 3) {

          // Outputs the robot with a white pixel
          image(imgOrangeLoadedRobotOne, intRobotOneX, intRobotOneY);

        }

      }

      // Creates a conditional selective algorithm to display robot two depending if a pixel is loaded
      if (blnShowRobot[2] == true) {

        // Outputs robot two
        image(imgFTCRobotTwo, intRobotTwoX, intRobotTwoY);

      } else if (blnShowRobot[2] == false && blnShowRobot[3] == true) {

        // Creates a conditional selective algorithm to check the colour of the pixel grabbed
        if (intColour == 0) {

          // Outputs the robot with a green pixel
          image(imgGreenLoadedRobotTwo, intRobotTwoX, intRobotTwoY);

        } else if (intColour == 1) {

          // Outputs the robot with a yellow pixel
          image(imgYellowLoadedRobotTwo, intRobotTwoX, intRobotTwoY);

        } else if (intColour == 2) {

          // Outputs the robot with a pink pixel
          image(imgPinkLoadedRobotTwo, intRobotTwoX, intRobotTwoY);

        } else if (intColour == 3) {

          // Outputs the robot with a white pixel
          image(imgOrangeLoadedRobotTwo, intRobotTwoX, intRobotTwoY);

        }

      }

    }

  }

  /**
   * Creates a method for when a key is pressed
   */
  public void keyPressed() {

    // Creates a conditional selective algorithm for the movement of robot one
    if (key == 'w') {

      // Moves robot one up
      intRobotOneY += intMovement[1];

    } else if (key == 'a') {

      // Moves robot one left
      intRobotOneX += intMovement[1];

    } else if (key == 's') {

      // Moves robot one down

      intRobotOneY += intMovement[0];

    } else if (key == 'd') {

      // Moves robot one right
      intRobotOneX += intMovement[0];

    }

    // Creates a conditional selective algorithm for the movement of robot two
    if (keyCode == UP) {

      // Moves robot two up
      intRobotTwoY += intMovement[1];

    } else if (keyCode == LEFT) {

      // Moves robot two left
      intRobotTwoX += intMovement[1];

    } else if (keyCode == DOWN) {

      // Moves robot two down
      intRobotTwoY += intMovement[0];

    } else if (keyCode == RIGHT) {

      // Moves robot two right
      intRobotTwoX += intMovement[0];

    }

  }

  /**
   * Creates a method to check if a map has been selected
   */
  public void mapSelection() {

    // Creates a conditional selective algorithm to check if the player has clicked the centerstage gamemode
    if (mousePressed == true && blnHideOptions[0] == false) {

      // Displays the centerstage map
      blnMapSelection[0] = true;

      // Updates the array to remove the button
      blnHideOptions[0] = true;

    }

  }

  /**
   * Creates a method to check if images have collided
   */
  public void collisionDetection() {

    // Creates a for loop for each game element
    for (int i = 0; i < blnElements.length; i++) {

      // Creates a conditional selective algorithm to check if robot one has intaked a pixel
      if (intRobotOneX + 100 > intElementX && intRobotOneX + 60 < intElementX + 40 && intRobotOneY + 118 > intElementY && intRobotOneY < intElementY + 40 && blnElements[i] == true) {

        // Changes the robot to have the pixel intaked
        blnShowRobot[0] = false;
        blnShowRobot[1] = true;

        // Hides the actual pixel image within the robot
        intElementX = intRobotOneX + 60;
        intElementY = intRobotOneY + 45;

      }

      // Creates a conditional selective algorithm to check if robot two has intaked a pixel
      if (intRobotTwoX + 100 > intElementX && intRobotTwoX + 60 < intElementX + 40 && intRobotTwoY + 118 > intElementY && intRobotTwoY < intElementY + 40 && blnElements[i] == true) {

        // Changes the robot to have the pixel intaked
        blnShowRobot[2] = false;
        blnShowRobot[3] = true;

        // Hides the actual pixel image within the robot
        intElementX = intRobotTwoX + 60;
        intElementY = intRobotTwoY + 45;

      }

      // Creates a conditional selective algorithm to check if the pixel has been outputted in the scoring area by robot one
      if (blnShowRobot[1] == true && blnElements[i] == true && intRobotOneY + 10 < 0 && intRobotOneX + 60 < 350
          && key == 'o') {

        // Sets a new colour for the pixels
        intColour = randColour.nextInt((3 - 0) + 1) + 0;

        // Updates the robot image
        blnShowRobot[0] = true;
        blnShowRobot[1] = false;

        // Updates the pixel's position
        intElementX = intRobotOneX + 70;
        intElementY = intRobotOneY + 120;

        // Stops the pixel from being intaked again
        blnElements[i] = false;

        // Creates a conditional selective algorithm to check where to place the next pixel
        if (i == 0) {

          // Sets the new coordinates of the pixel
          intElementX = 280;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 1) {

          // Sets the new coordinates of the pixel
          intElementX = 358;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 2) {

          // Sets the new coordinates of the pixel
          intElementX = 504;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 3) {

          // Sets the new coordinates of the pixel
          intElementX = 580;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 4) {

          // Sets the new coordinates of the pixel
          intElementX = 656;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 5) {

          // Sets the new coordinates of the pixel
          intElementX = 204;
          intElementY = 650;

          // Displays the next pixel
          blnElements[0] = true;

        }

        // Adds to the current score
        intPlayerOneScore++;

      }

      // Creates a conditional selective algorithm to check if the pixel has been outputted in the scoring area by robot two
      if (blnShowRobot[3] == true && blnElements[i] == true && intRobotTwoY + 10 < 0 && intRobotTwoX + 60 > 510 && key == 'o') {

        // Sets a new colour for the pixels
        intColour = randColour.nextInt((3 - 0) + 1) + 0;

        // Updates the robot image
        blnShowRobot[2] = true;
        blnShowRobot[3] = false;

        // Updates the pixel's position
        intElementX = intRobotTwoX + 70;
        intElementY = intRobotTwoY + 120;

        // Stops the pixel from being intaked again
        blnElements[i] = false;

        // Creates a conditional selective algorithm to check where to place the next pixel
        if (i == 0) {

          // Sets the new coordinates of the pixel
          intElementX = 280;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 1) {

          // Sets the new coordinates of the pixel
          intElementX = 358;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 2) {

          // Sets the new coordinates of the pixel
          intElementX = 504;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 3) {

          // Sets the new coordinates of the pixel
          intElementX = 580;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 4) {

          // Sets the new coordinates of the pixel
          intElementX = 656;
          intElementY = 650;

          // Displays the next pixel
          blnElements[i + 1] = true;

        } else if (i == 5) {

          // Sets the new coordinates of the pixel
          intElementX = 204;
          intElementY = 650;

          // Displays the next pixel
          blnElements[0] = true;

        }

        // Adds to the current score
        intPlayerTwoScore++;

      }

    }

    // Creates a conditional selective algorithm to check if robot one has left the screen
    if (intRobotOneX + 160 > width) {

      // Moves the robot back onto the screen
      intRobotOneX -= 5;

    } else if (intRobotOneX + 20 < 0) {

      // Moves the robot back onto the screen
      intRobotOneX += 5;

    } else if (intRobotOneY + 136 > height) {

      // Moves the robot back onto the screen
      intRobotOneY -= 5;

    } else if (intRobotOneY + 40 < 0) {

      // Moves the robot back onto the screen
      intRobotOneY += 5;

    }

    // Creates a conditional selective algorithm to check if robot two has left the screen
    if (intRobotTwoX + 164 > width) {

      // Moves the robot back onto the screen
      intRobotTwoX -= 5;

    } else if (intRobotTwoX + 18 < 0) {

      // Moves the robot back onto the screen
      intRobotTwoX += 5;

    } else if (intRobotTwoY + 136 > height) {

      // Moves the robot back onto the screen
      intRobotTwoY -= 5;

    } else if (intRobotTwoY + 40 < 0) {

      // Moves the robot back onto the screen
      intRobotTwoY += 5;

    }

    // Creates a conditional selective algorithm to check if the robots have collided with each other
    if (intRobotOneX + 160 > intRobotTwoX && intRobotOneX < intRobotTwoX + 164 && intRobotOneY + 136 > intRobotTwoY && intRobotOneY < intRobotTwoY + 136) {

      // Moves each robot in opposite directions
      intRobotOneX -= 5;
      intRobotTwoX += 5;

    } 

  }
  
  /**
   * Creates a method to check the current time
   */
  public void timeCheck(){

    // Creates a conditional selective algorithm to check the time
    if (fltTimeDisplacement < 30000){

      // Displays the 0:00 timer
      image(img000Timer, width / 2 - 60, 0);

    } else if (fltTimeDisplacement > 30000 && fltTimeDisplacement < 60000) {

      // Displays the 0:30 timer
      image(img050Timer, width / 2 - 60, 0);

    } else if (fltTimeDisplacement > 60000 && fltTimeDisplacement < 90000){

      // Displays the 1:00 timer
      image(img100Timer, width / 2 - 60, 0);

    } else if (fltTimeDisplacement > 90000 && fltTimeDisplacement < 120000){

      // Displays the 1:30 timer
      image(img150Timer, width / 2 - 60, 0);

    } else if (fltTimeDisplacement > 120000 && fltTimeDisplacement < 150000){

      // Displays the 2:00 timer
      image(img200Timer, width / 2 - 60, 0);

    } else if (fltTimeDisplacement > 150000){
      
      // Removes the robots
      blnShowRobot[0] = false;
      blnShowRobot[2] = false;

      // Stops the draw() method from looping
      noLoop();

      // Creates a conditional selective algorithm to check which player has won
      if (intPlayerOneScore > intPlayerTwoScore){

        // Outputs a winning screen for blue alliance
        image(imgWinnerBlue, 0, 0);
        
      } else if (intPlayerOneScore < intPlayerTwoScore){

        // Outputs a winning screen for red alliance
        image(imgWinnerRed, 0, 0);

      }
      
    }

  }
  
}