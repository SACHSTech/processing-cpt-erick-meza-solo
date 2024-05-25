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
  boolean[] blnHideOptions = new boolean[3];

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

    // Resizes each image
    imgCenterstage.resize(width, height);
    imgCenterstageLogo.resize(200, 100);
    imgPowerPlay.resize(width, height);
    imgPowerplayLogo.resize(200, 100);
    imgFreightFrenzy.resize(width, height);
    imgFreightFrenzyLogo.resize(200, 100);
    imgFTCLogo.resize(200, 100);

    // Outputs all logos
    image(imgFTCLogo, 10, 10);
    image(imgCenterstageLogo, width / 2 - 400, height / 2 - 150);
    image(imgPowerplayLogo, width / 2 - 100, height / 2);
    image(imgFreightFrenzyLogo, width / 2 + 200, height / 2 + 150);

    // Outputs an introduction text
    fill(0, 0, 0);
    textSize(35);
    text("PRESS ANY GAMEMODE TO BEGIN", 40, 600);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // Creates a conditional selective algorithm to check if the player has clicked the centerstage gamemode
    if (mousePressed == true && blnHideOptions[0] == false && (mouseX > width / 2 - 400 && mouseX < width / 2 - 400 + 200 && mouseY > height / 2 - 150 && mouseY < height / 2 - 150 + 100)) {

      // Calls the centerstage method
      centerstage();

      // Updates the array to remove the button
      blnHideOptions[0] = true;

    // Checks if the player has clicked the powerplay gamemode
    } else if (mousePressed == true && blnHideOptions[1] == false && (mouseX > width / 2 - 100 && mouseX < width / 2 - 100 + 200 && mouseY > height / 2 && mouseY < height / 2 + 100)) {

      // Calls the powerplay method
      powerplay();

      // Updates the array to remove the button
      blnHideOptions[1] = true;
    
      // Checks if the player has clicked the freight frenzy gamemode
    } else if (mousePressed == true && blnHideOptions[0] == false && (mouseX > width / 2 + 200 && mouseX < width / 2 + 200 + 200 && mouseY > height / 2 + 150 && mouseY < height / 2 + 150 + 100)) {

      // Calls the freight frenzy method
      freightFrenzy();

      // Updates the array to remove the button
      blnHideOptions[2] = true;

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

    // Creates a conditional selective algorithm to check if the person has clicked TAB
    if (keyCode == TAB) {

      // Creates a for loop to reset the array for gamemode buttons
      for (int i = 0; i < blnHideOptions.length; i++) {

        // Updates the array to show the buttons
        blnHideOptions[i] = false;

      }

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
  
}