import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // Initializes variables
  PImage imgCenterstage;
  PImage imgPowerPlay;
  PImage imgFreightFrenzy;
  PImage imgFTCLogo;
  PImage imgCenterstageLogo;
  PImage imgPowerplayLogo;
  PImage imgFreightFrenzyLogo;
  PImage imgFTCRobot;
  PImage imgLoadedRobot;
  PImage imgGreenPixel;
  PImage imgRedCone;
  boolean[] blnHideOptions = new boolean[3];
  boolean[] blnMapeSelection = new boolean[3];
  boolean[] blnShowRobot = { false, false };
  boolean[] blnElements = { true, false, false, false };
  int[] intMovement = { 20, -20 };
  int intRobotX = 20;
  int intRobotY = 300;
  int intElementX = 204;
  int intElementY = 650;
  int intScore = 0;

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
    imgPowerPlay = loadImage("Gamemodes/Powerplay.png");
    imgFreightFrenzy = loadImage("Gamemodes/FreightFrenzy.png");
    imgFTCLogo = loadImage("Logos/FTC_Logo.png");
    imgCenterstageLogo = loadImage("Logos/Centerstage_Logo.png");
    imgPowerplayLogo = loadImage("Logos/Powerplay_Logo.png");
    imgFreightFrenzyLogo = loadImage("Logos/FreightFrenzy_Logo.png");
    imgFTCRobot = loadImage("Robots/PlayerRobot.png");
    imgLoadedRobot = loadImage("Robots/Robot_With_Pixel.png");
    imgGreenPixel = loadImage("Game_Elements/GreenPixel.png");
    imgRedCone = loadImage("Game_Elements/RedCone.png");

    // Resizes each image
    imgCenterstage.resize(width, height);
    imgCenterstageLogo.resize(200, 100);
    imgPowerPlay.resize(width, height);
    imgPowerplayLogo.resize(200, 100);
    imgFreightFrenzy.resize(width, height);
    imgFreightFrenzyLogo.resize(200, 100);
    imgFTCLogo.resize(200, 100);
    imgFTCRobot.resize(175, 175);
    imgLoadedRobot.resize(175, 175);
    imgGreenPixel.resize(40, 40);
    imgRedCone.resize(40, 40);

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

      // Creates a conditional selective algorithm to output game elements
      if (blnElements[0] == true) {

        // Outputs a green pixel in the first pile
        image(imgGreenPixel, intElementX, intElementY);

      } else if (blnElements[1] == true) {

        // Outputs a green pixel in the second pile
        image(imgGreenPixel, intElementX, intElementY);

      } else if (blnElements[2] == true) {

        // Outputs a green pixel in the third pile
        image(imgGreenPixel, 400, 650);
      } else if (blnElements[3] == true) {

        // Outputs a green pixel in the fourth pile
        image(imgGreenPixel, 600, 850);

      }

      // Outputs the score
      text(intScore, 800, 100);

      // Creates a for loop for each game element
      for (int i = 0; i < blnElements.length; i++) {

        // Creates a conditional selective algorithm to check if the robot has intaked a pixel
        if (intRobotX + 120 > intElementX && intRobotX + 60 < intElementX + 40 && intRobotY + 110 > intElementY
            && intRobotY < intElementY + 40 && blnElements[i] == true) {

          // Changes the robot to have the pixel intaked
          blnShowRobot[0] = false;
          blnShowRobot[1] = true;

          // Hides the actual pixel image within the robot
          intElementX = intRobotX + 60;
          intElementY = intRobotY + 45;

        }

        // Creates a conditional selective algorithm to check if the pixel has been outputted in the scoring area
        if (blnShowRobot[1] == true && intRobotY + 20 < 0 && intRobotX + 60 < 350 && key == 'o') {

          // Updates the robot image
          blnShowRobot[0] = true;
          blnShowRobot[1] = false;

          // Updates the pixel's position
          intElementX = intRobotX + 70;
          intElementY = intRobotY + 120;

          // Stops the pixel from being intaked again
          blnElements[i] = false;

          // Adds to the current score
          intScore++;

          // Calls the pixelStatus() method to make a new pixel available
          pixelStatus();

          // Resets the pixel's position
          intElementX = 204;
          intElementY = 650;

        }

      }

      // Creates a conditional selectivealgorithm to output the robot depending if the pixel is intaked or not
      if (blnShowRobot[0] == true) {

        // Outputs the robot with no pixel
        image(imgFTCRobot, intRobotX, intRobotY);

      } else if (blnShowRobot[0] == false && blnShowRobot[1] == true) {

        // Outputs the robot with a pixel
        image(imgLoadedRobot, intRobotX, intRobotY);

      }

    } else if (blnMapeSelection[1] == true) {

      // Outputs the robot
      blnShowRobot[0] = true;

      // Calls the powerplay method
      powerplay();

    } else if (blnMapeSelection[2] == true) {

      // Outputs the robot
      blnShowRobot[0] = true;

      // Calls the freight frenzy
      freightFrenzy();

    }

    // Creates a conditional selective algorithm to check if the robot has left the screen
    if (intRobotX + 175 > width) {

      // Moves the robot back onto the screen
      intRobotX -= 5;

    } else if (intRobotX + 18 < 0) {

      // Moves the robot back onto the screen
      intRobotX += 5;

    } else if (intRobotY + 136 > height) {

      // Moves the robot back onto the screen
      intRobotY -= 5;

    } else if (intRobotY + 40 < 0) {

      // Moves the robot back onto the screen
      intRobotY += 5;

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
   * Creates a method to run code affiliated with powerplay
   */
  public void powerplay() {

    // Outputs the powerplay field
    image(imgPowerPlay, 0, 0);

  }

  /**
   * Creates a method to run code affiliated with freight frenzy
   */
  public void freightFrenzy() {
    // Outputs the freight frenzy field
    image(imgFreightFrenzy, 0, 0);

  }

  /**
   * Creates a method for when a key is pressed
   */
  public void keyPressed() {

    // Creates a conditional selective algorithm to check if the person has clicked
    // TAB
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

    if (key == 'w') {
      intRobotY -= 20;
    } else if (key == 'a') {
      intRobotX -= 20;
    } else if (key == 's') {
      intRobotY += 20;
    } else if (key == 'd') {
      intRobotX += 20;
    }

  }

  public void mapSelection() {
    // Creates a conditional selective algorithm to check if the player has clicked
    // the centerstage gamemode
    if (mousePressed == true && blnHideOptions[0] == false && (mouseX > width / 2 - 400
        && mouseX < width / 2 - 400 + 200 && mouseY > height / 2 - 150 && mouseY < height / 2 - 150 + 100)) {

      // Calls the centerstage method
      image(imgCenterstage, 0, 0);
      blnMapeSelection[0] = true;

      // Updates the array to remove the button
      blnHideOptions[0] = true;

      // Checks if the player has clicked the powerplay gamemode
    } else if (mousePressed == true && blnHideOptions[1] == false && (mouseX > width / 2 - 100
        && mouseX < width / 2 - 100 + 200 && mouseY > height / 2 && mouseY < height / 2 + 100)) {

      // Calls the powerplay method
      powerplay();
      blnMapeSelection[1] = true;

      // Updates the array to remove the button
      blnHideOptions[1] = true;

      // Checks if the player has clicked the freight frenzy gamemode
    } else if (mousePressed == true && blnHideOptions[0] == false && (mouseX > width / 2 + 200
        && mouseX < width / 2 + 200 + 200 && mouseY > height / 2 + 150 && mouseY < height / 2 + 150 + 100)) {

      // Calls the freight frenzy method
      freightFrenzy();
      blnMapeSelection[2] = true;

      // Updates the array to remove the button
      blnHideOptions[2] = true;

    }
  }

  /**
   * Creates a method to check the status of each pixel
   */
  public void pixelStatus() {

    // Creates a for loop to check each game element
    for (int i = 1; i < blnElements.length; i++) {

      // Creates a conditional selective algorithm to check the status of the previous pixel
      if (blnElements[i - 1] == false) {

        // Sets the current pixel to true
        blnElements[i] = true;

        // Breaks the for loop
        break;

      }
    }
  }
}