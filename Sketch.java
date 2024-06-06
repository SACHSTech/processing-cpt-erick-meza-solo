import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch extends PApplet {

  // Initializes variables
  PImage imgCenterstage;
  PImage imgFTCLogo;
  PImage imgCenterstageLogo;
  PImage imgPowerplayLogo;
  PImage imgFreightFrenzyLogo;
  PImage imgFTCRobotOne;
  PImage imgFTCRobotTwo;
  PImage imgGreenLoadedRobot;
  PImage imgPinkLoadedRobot;
  PImage imgYellowPixel;
  PImage imgGreenPixel;
  PImage imgPinkPixel;
  PImage imgWhitePixel;
  boolean[] blnHideOptions = new boolean[3];
  boolean[] blnMapeSelection = new boolean[3];
  boolean[] blnShowRobot = { false, false, false, false };
  boolean[] blnElements = { true, false, false, false, false, false };
  int[] intMovement = { 10, -10 };
  int intRobotOneX = 20;
  int intRobotOneY = 300;
  int intRobotTwoX = 420;
  int intRobotTwoY = 300;
  int intElementX = 204;
  int intElementY = 650;
  int intScore = 0;
  int intColour = 0;
  Random randColour = new Random();

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
    imgCenterstage = loadImage("Gamemodes/Centerstage.png");
    imgFTCLogo = loadImage("Logos/FTC_Logo.png");
    imgCenterstageLogo = loadImage("Logos/Centerstage_Logo.png");
    imgPowerplayLogo = loadImage("Logos/Powerplay_Logo.png");
    imgFreightFrenzyLogo = loadImage("Logos/FreightFrenzy_Logo.png");
    imgFTCRobotOne = loadImage("Robots/FTCRobotOne.png");
    imgFTCRobotTwo = loadImage("Robots/FTCRobotTwo.png");
    imgGreenLoadedRobot = loadImage("Loaded Robots/RobotOne (Green).png");
    imgPinkLoadedRobot = loadImage("Loaded Robots/RobotOne (Pink).png");
    imgYellowPixel = loadImage("Game_Elements/Pixel (Yellow).png");
    imgGreenPixel = loadImage("Game_Elements/Pixel (Green).png");
    imgPinkPixel = loadImage("Game_Elements/Pixel (Pink).png");
    imgWhitePixel = loadImage("Game_Elements/Pixel (White).png");

    // Resizes each image
    imgCenterstage.resize(width, height);
    imgCenterstageLogo.resize(200, 100);
    imgPowerplayLogo.resize(200, 100);
    imgFreightFrenzyLogo.resize(200, 100);
    imgFTCLogo.resize(200, 100);
    imgFTCRobotOne.resize(175, 175);
    imgFTCRobotTwo.resize(175, 175);
    imgGreenLoadedRobot.resize(175, 175);
    imgPinkLoadedRobot.resize(175, 175);
    imgYellowPixel.resize(40, 40);
    imgGreenPixel.resize(40, 40);
    imgPinkPixel.resize(40, 40);
    imgWhitePixel.resize(40, 40);

    // Outputs all logos
    image(imgFTCLogo, 10, 10);
    image(imgCenterstageLogo, width / 2 - 400, height / 2 - 150);
    image(imgPowerplayLogo, width / 2 - 100, height / 2);
    image(imgFreightFrenzyLogo, width / 2 + 200, height / 2 + 150);

    // Outputs an introduction text
    fill(0, 0, 0);
    textSize(35);
    text("PRESS ANY GAMEMODE TO BEGIN", 40, 600);

    // Sets the title of the screen
    surface.setTitle("Erick M - ICS3U1 CPT");

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // Calls the map selection method
    mapSelection();

    // Creates a conditional selective algorithm to check which map has been chosen
    if (blnMapeSelection[0] == true) {

      // Calls the centerstage method
      centerstage();

      // Outputs the robot
      blnShowRobot[0] = true;
      blnShowRobot[2] = true;

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
          image(imgWhitePixel, intElementX, intElementY);
        }

      }

      // Outputs the score
      text(intScore, 800, 100);

      // Creates a for loop for each game element
      for (int i = 0; i < blnElements.length; i++) {

        // Creates a conditional selective algorithm to check if the robot has intaked a pixel
        if (intRobotOneX + 90 > intElementX && intRobotOneX + 40 < intElementX + 40 && intRobotOneY + 118 > intElementY && intRobotOneY < intElementY + 40 && blnElements[i] == true) {

          // Changes the robot to have the pixel intaked
          blnShowRobot[0] = false;
          blnShowRobot[1] = true;

          // Hides the actual pixel image within the robot
          intElementX = intRobotOneX + 60;
          intElementY = intRobotOneY + 35;

        }

        // Creates a conditional selective algorithm to check if the pixel has been outputted in the scoring area
        if (blnShowRobot[1] == true && blnElements[i] == true && intRobotOneY + 10 < 0 && intRobotOneX + 60 < 350 && key == 'o') {

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
          intScore++;

        }

      }

      // Creates a conditional selective algorithm to output robot one depending if the pixel is intaked or not
      if (blnShowRobot[0] == true) {

        // Outputs the robot with no pixel
        image(imgFTCRobotOne, intRobotOneX, intRobotOneY);

      } else if (blnShowRobot[0] == false && blnShowRobot[1] == true) {

        if (intColour == 0) {

          // Outputs the robot with a green pixel
          image(imgGreenLoadedRobot, intRobotOneX, intRobotOneY);

        } else if (intColour == 2){

          //Outputs the robot with a pink pixel
          image(imgPinkLoadedRobot, intRobotOneX, intRobotOneY);
        }

      }

      // Creates a conditional selective algorithm to display robot two depending if a pixel is loaded
      if (blnShowRobot[2] == true) {

        // Outputs robot two
        image(imgFTCRobotTwo, intRobotTwoX, intRobotTwoY);
      }

    }

    // Creates a conditional selective algorithm to check if the robot has left the screen
    if (intRobotOneX + 175 > width) {

      // Moves the robot back onto the screen
      intRobotOneX -= 5;

    } else if (intRobotOneX + 18 < 0) {

      // Moves the robot back onto the screen
      intRobotOneX += 5;

    } else if (intRobotOneY + 136 > height) {

      // Moves the robot back onto the screen
      intRobotOneY -= 5;

    } else if (intRobotOneY + 40 < 0) {

      // Moves the robot back onto the screen
      intRobotOneY += 5;

    }
  }

  /**
   * Creates a method to run code affiliated with centerstage
   */
  public void centerstage() {

    // Outputs the centerstage field
    image(imgCenterstage, 0, 0);

  }

  /**
   * Creates a method for when a key is pressed
   */
  public void keyPressed() {

    // Creates a conditional selective algorithm to check if the person has clicked TAB
    if (keyCode == TAB) {

      // Creates a for loop to reset the array for gamemode buttons
      for (int i = 0; i < blnHideOptions.length; i++) {

        // Updates the array to show the buttons
        blnHideOptions[i] = false;

      }

      // Outputs the background
      background(255, 255, 255);

      // Outputs logos and buttons
      image(imgFTCLogo, 10, 10);
      image(imgCenterstageLogo, width / 2 - 400, height / 2 - 150);
      image(imgPowerplayLogo, width / 2 - 100, height / 2);
      image(imgFreightFrenzyLogo, width / 2 + 200, height / 2 + 150);

      // Creates an introduction text
      fill(0, 0, 0);
      textSize(35);
      text("PRESS ANY GAMEMODE TO BEGIN", 40, 600);
    }

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

  public void mapSelection() {

    // Creates a conditional selective algorithm to check if the player has clicked the centerstage gamemode
    if (mousePressed == true && blnHideOptions[0] == false && (mouseX > width / 2 - 400 && mouseX < width / 2 - 400 + 200 && mouseY > height / 2 - 150 && mouseY < height / 2 - 150 + 100)) {

      // Calls the centerstage method
      image(imgCenterstage, 0, 0);
      blnMapeSelection[0] = true;

      // Updates the array to remove the button
      blnHideOptions[0] = true;

    }

  }

}