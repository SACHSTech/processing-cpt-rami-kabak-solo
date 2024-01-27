import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Pixel Patty! A burger game built using PApplet processing, specialized in design.
 * @author Rami Kabak
 */
public class Sketch extends PApplet {  
  // UI Variable Setup
  PImage mainMenu;
  PImage cookText;
  PImage restaurantBackgroundDay1;
  PImage restaurantBackgroundDay2;
  PImage restaurantBackgroundDay3;
  PImage topMenu;
  PImage starRating;
  PImage ingredientMenu;
  PImage speechBubble;
  PImage checkMark;
  
  // Font Variable Setup
  PFont pixelFont;

  // Ingredient Images
  PImage bottomBunImage;
  PImage topBunImage;
  PImage lettuceImage;
  PImage cheeseImage;
  PImage tomatoImage;
  PImage pattyImage;
  PImage onionImage;

  // Customers
  // Business Day
  PImage businessMan1;
  PImage businessMan2;
  PImage businessMan3;
  PImage businessMan4;
  PImage businessMan5;

  // City Vibes
  PImage casualMan1;
  PImage casualMan2;
  PImage casualMan3;
  PImage casualMan4;
  PImage casualMan5;

  // Farmers Harvest
  PImage farmerMan1;
  PImage farmerWoman1;
  PImage farmerMan2;
  PImage farmerMan3;
  PImage farmerWoman2;

  // Ingredient Positioning
  float cookTextX;
  float cookTextY;
  float bottomBunX;
  float bottomBunY;
  float topBunX; 
  float topBunY; 
  float lettuceX;
  float lettuceY;
  float cheeseX;
  float cheeseY; 
  float pattyX;
  float pattyY;
  float tomatoX; 
  float tomatoY; 
  float onionX;
  float onionY;

  // Sprite sizes
  int cookTextWidth;
  int cookTextHeight;
  int ingredientMenuHeight;
  int bottomBunWidth;
  int bottomBunHeight;
  int topBunWidth;
  int topBunHeight;
  int lettuceWidth;
  int lettuceHeight;
  int cheeseWidth;
  int cheeseHeight;
  int pattyWidth;
  int pattyHeight;
  int tomatoWidth;
  int tomatoHeight;
  int onionWidth;
  int onionHeight;

  // Booleans
  boolean inMainMenu;
  boolean isMousePressed;
  boolean wrongIngredientSelected;

  // Order System Variables
  int restaurantRating;
  int currentCustomerIndex;
  ArrayList<String[]> customerOrders;
  boolean[] ingredientSelected;
  String[] ingredientNames = {"Bottom Bun", "Top Bun", "Lettuce", "Cheese", "Onion", "Patty", "Tomato"};

  // Other variables
  int day1FrameRate;
  int day2FrameRate;
  int day3FrameRate;
  int fadeInScreenDay1;
  int fadeInScreenDay2;
  int fadeInScreenDay3;
  int fadeInText;
  int gameTimer;
  int startTime;
  int impatienceTime = 3000;
  int customerTimer;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    // Variable initialization

    // Load Font
    pixelFont = createFont("../Images/Fonts/Symtext.ttf", 32);

    // Load All Images

    // UI
    mainMenu = loadImage("../Images/UI/MainMenu.png");
    ingredientMenu = loadImage("../Images/UI/BottomMenu.png");
    topMenu = loadImage("../Images/UI/TopMenu.png");
    cookText = loadImage("../Images/UI/CookText.png");
    starRating = loadImage("../Images/UI/Star.png");
    speechBubble = loadImage("../Images/UI/SpeechBubble.png");
    checkMark = loadImage("../Images/UI/Checkmark.png");

    restaurantBackgroundDay1 = loadImage("../Images/UI/RestaurantBackground.png");
    restaurantBackgroundDay2 = loadImage("../Images/UI/RestaurantBackground2.png");
    restaurantBackgroundDay3 = loadImage("../Images/UI/RestaurantBackground3.png");

    // Ingredients
    bottomBunImage = loadImage("../Images/Ingredients/BottomBun.png");
    topBunImage = loadImage("../Images/Ingredients/TopBun.png");
    lettuceImage = loadImage("../Images/Ingredients/Lettuce.png");
    cheeseImage = loadImage("../Images/Ingredients/Cheese.png");
    onionImage = loadImage("../Images/Ingredients/Onion.png");
    pattyImage = loadImage("../Images/Ingredients/Patty.png");
    tomatoImage = loadImage("../Images/Ingredients/Tomato.png");

    // Characters

    // Business Day
    businessMan1 = loadImage("../Images/Characters/BusinessMan1.png");
    businessMan2 = loadImage("../Images/Characters/BusinessMan2.png"); 
    businessMan3 = loadImage("../Images/Characters/BusinessMan3.png");
    businessMan4 = loadImage("../Images/Characters/BusinessMan4.png");
    businessMan5 = loadImage("../Images/Characters/BusinessMan5.png");

    // City Vibes
    casualMan1 = loadImage("../Images/Characters/CasualMan1.png");
    casualMan2 = loadImage("../Images/Characters/CasualMan2.png");
    casualMan3 = loadImage("../Images/Characters/CasualMan3.png");
    casualMan4 = loadImage("../Images/Characters/CasualMan4.png");
    casualMan5 = loadImage("../Images/Characters/CasualMan5.png");

    // Farmers Harvest
    farmerMan1 = loadImage("../Images/Characters/FarmerMan1.png");
    farmerMan2 = loadImage("../Images/Characters/FarmerMan2.png");
    farmerWoman1 = loadImage("../Images/Characters/FarmerWoman1.png");
    farmerMan3 = loadImage("../Images/Characters/FarmerMan3.png");
    farmerWoman2 = loadImage("../Images/Characters/FarmerWoman2.png");

    // Positions
    cookTextX = 302;
    cookTextY = 305;
    bottomBunX = 32;
    bottomBunY = 735;
    topBunX = 145;
    topBunY = 725;
    lettuceX = 250;
    lettuceY = 715;
    cheeseX = 360;
    cheeseY = 720;
    onionX = 585;
    onionY = 720;
    pattyX = 480;
    pattyY = 720;
    tomatoX = 695;
    tomatoY = 725;

    // Sizes
    cookTextWidth = 197;
    cookTextHeight = 47;
    ingredientMenuHeight = 120;
    bottomBunWidth = 73;
    bottomBunHeight = 20; 
    topBunWidth = 68;
    topBunHeight = 37;
    lettuceWidth = 77;
    lettuceHeight = 55;
    cheeseWidth = 78;
    cheeseHeight = 45;
    pattyWidth = 66;
    pattyHeight = 44;
    tomatoWidth = 76;
    tomatoHeight = 47;
    onionWidth = 74;
    onionHeight = 52;

    // Resize images to variable
    ingredientMenu.resize(width, ingredientMenuHeight);
    bottomBunImage.resize(bottomBunWidth, bottomBunHeight);
    topBunImage.resize(topBunWidth, topBunHeight);
    lettuceImage.resize(lettuceWidth, lettuceHeight);
    cheeseImage.resize(cheeseWidth, cheeseHeight);
    pattyImage.resize(pattyWidth, pattyHeight);  

    // Setting variables
    inMainMenu = true;
    wrongIngredientSelected = false;
    isMousePressed = false;

    day1FrameRate = 0;
    day2FrameRate = 0;
    
    gameTimer = 3 * 60;
    startTime = millis();

    fadeInScreenDay1 = 255;
    fadeInScreenDay2 = 255;
    fadeInScreenDay3 = 255;
    fadeInText = 0;

    restaurantRating = 5;
    currentCustomerIndex = 0;

    // Order system setup
    
    // Arrays
    ingredientSelected = new boolean[7];
    customerOrders = new ArrayList<>();

    // Business Day
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Cheese", "Patty", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Cheese", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Onion", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Cheese", "Onion", "Top Bun"});

    // City Vibes
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Lettuce", "Onion", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Cheese", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Lettuce", "Cheese", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Cheese", "Lettuce", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Onion", "Lettuce", "Top Bun"});

    // Farmers Harvest
    customerOrders.add(new String[]{"Bottom Bun", "Cheese", "Tomato", "Lettuce", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Tomato", "Onion", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Cheese", "Onion", "Lettuce", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Patty", "Lettuce", "Tomato", "Top Bun"});
    customerOrders.add(new String[]{"Bottom Bun", "Lettuce", "Onion", "Tomato", "Top Bun"});
  
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // If check to draw main menu if boolean is true
    if (inMainMenu) {
      drawMainMenu();
    } else {
      // If check to see if restaurant rating is still above 1 to continue or end game
      if (restaurantRating > 1) {
        // If checks to change days based on the customer index (how many customers served per day (5))
        if (currentCustomerIndex >= 15) {
          winScreen();
        } else if (currentCustomerIndex >= 10 && currentCustomerIndex < 15) {
          Day3();
        } else if (currentCustomerIndex >= 5 && currentCustomerIndex < 10) {
          Day2();
        } else {
          Day1();
        }
        // If check to see if wrong ingredient is selected to flash red screen and reset boolean
        if (wrongIngredientSelected) {
          flashRedScreen();
          wrongIngredientSelected = false;
        }
        // If restaurant rating is below 2 it will activate lose screen, with screen fade in effect 
      } else {
        // If check to decrease fade alpha variable on draw method to create the transition
        if (fadeInText < 255) {
          fadeInText += 2;
        }

        background(0);
        fill(255, fadeInText);
  
        textAlign(CENTER, CENTER);
        textFont(pixelFont);
        textSize(30);
        text("You have a 1 star rating,", 275, 350);
        text("you are out of business!", 510, 410);
      }
    }
  }

  /**
   * Method to set background to Red to activate when wrong ingredient is selected
   */
  public void flashRedScreen() {
    background(255, 0, 0);
  }

  /**
   * Method to draw main menu and call hover resize method on the start button
   */
  public void drawMainMenu() {
    image(mainMenu,0,0);
    resizeOnHover(cookText, cookTextX, cookTextY, cookTextWidth, cookTextHeight, 1.25);
  }

  /**
   * Day1 method to start the game, contains many expressions and methods explained below in the method
   */
  public void Day1() {
    // Custom frame count to control timer, customers, and transition
    day1FrameRate++;

    image(restaurantBackgroundDay1, 0, 162);

    // Display customers after fade-in effect is done
    if (day1FrameRate > 400) {
      displayCustomers();
      checkIngredientClicks();
    }

    // Display UI
    image(ingredientMenu,0,680);
    image(topMenu,0,0);
    
    // Draw stars method, draws how much restaurant rating you have
    drawStars(restaurantRating);

    // Day count
    textAlign(CENTER, CENTER);
    textFont(pixelFont);
    fill(0);
    textSize(65);
    text("Day 1", 140, 65);

    // Display ingredients with resize on hover method, visually appealing
    resizeOnHover(bottomBunImage, bottomBunX, bottomBunY, bottomBunWidth, bottomBunHeight, 1.5);
    resizeOnHover(topBunImage, topBunX, topBunY, topBunWidth, topBunHeight, 1.5);
    resizeOnHover(lettuceImage, lettuceX, lettuceY, lettuceWidth, lettuceHeight, 1.5);
    resizeOnHover(cheeseImage, cheeseX, cheeseY, cheeseWidth, cheeseHeight, 1.5);
    resizeOnHover(pattyImage, pattyX, pattyY, pattyWidth, pattyHeight, 1.5);
    resizeOnHover(tomatoImage, tomatoX, tomatoY, tomatoWidth, tomatoHeight, 1.5);
    resizeOnHover(onionImage, onionX, onionY, onionWidth, onionHeight, 1.5);

    // Transition into the first day
    if (day1FrameRate <= 200) {
      fill(0);
      rect(0, 0, width, height);
      fill(255);
      textAlign(CENTER, CENTER);
      textFont(pixelFont);
      textSize(100);
      text("Day 1", 410, 380);
      textSize(50);
      text("Business Day", 410, 475);
    } else {
      // If check to decrease fade alpha variable on draw method to create the transition
      if (fadeInScreenDay1 > 0) {
        fadeInScreenDay1 -= 2;
        fill(0, fadeInScreenDay1);
        rect(0, 0, width, height);
      }
    }
    // Only starts countdown when the user is not in the main menu
    if (!inMainMenu) {
      countdown();
    }
  }

  /**
   * Day2 method to go to next level, contains many expressions and methods explained below in the method
   */
  public void Day2() {
    // Custom frame count to control timer, customers, and transition
    day2FrameRate++;

    image(restaurantBackgroundDay2, 0, 181);

    // Display customers after fade-in effect is done
    if (day2FrameRate > 400) {
      displayCustomers();
      checkIngredientClicks();
    }

    // Display UI
    image(ingredientMenu,0,680);
    image(topMenu,0,0);
    
    // Draw stars method, draws how much restaurant rating you have
    drawStars(restaurantRating);

    // Day Count
    textAlign(CENTER, CENTER);
    textFont(pixelFont);
    fill(0);
    textSize(65);
    text("Day 2", 140, 65);

    // Display ingredients with resize on hover method, visually appealing
    resizeOnHover(bottomBunImage, bottomBunX, bottomBunY, bottomBunWidth, bottomBunHeight, 1.5);
    resizeOnHover(topBunImage, topBunX, topBunY, topBunWidth, topBunHeight, 1.5);
    resizeOnHover(lettuceImage, lettuceX, lettuceY, lettuceWidth, lettuceHeight, 1.5);
    resizeOnHover(cheeseImage, cheeseX, cheeseY, cheeseWidth, cheeseHeight, 1.5);
    resizeOnHover(pattyImage, pattyX, pattyY, pattyWidth, pattyHeight, 1.5);
    resizeOnHover(tomatoImage, tomatoX, tomatoY, tomatoWidth, tomatoHeight, 1.5);
    resizeOnHover(onionImage, onionX, onionY, onionWidth, onionHeight, 1.5);
   
    // Transition into the second day
    if (day2FrameRate <= 200) {
      fill(0);
      rect(0, 0, width, height);
      fill(255);
      textAlign(CENTER, CENTER);
      textFont(pixelFont);
      textSize(100);
      text("Day 2", 410, 380);
      textSize(50);
      text("City Vibes", 410, 475);
    } else {
      // If check to decrease fade alpha variable on draw method to create the transition
      if (fadeInScreenDay2 > 0) {
        fadeInScreenDay2 -= 2;
        fill(0, fadeInScreenDay2);
        rect(0, 0, width, height);
      }
    }
    // Only starts countdown when the user is not in the main menu
    if (!inMainMenu) {
      countdown();
    }
  }

  /**
   * Day3 method to go to final level, contains many expressions and methods explained below in the method
   */
  public void Day3() {
    // Custom frame count to control timer, customers, and transition
    day3FrameRate++;

    image(restaurantBackgroundDay3, 0, 181);

    // Display customers after fade-in effect is done
    if (day3FrameRate > 400) {
      displayCustomers();
      checkIngredientClicks();
    }

    // Display UI
    image(ingredientMenu,0,680);
    image(topMenu,0,0);
    
    // Draw stars method, draws how much restaurant rating you have
    drawStars(restaurantRating);

    // Day Count
    textAlign(CENTER, CENTER);
    textFont(pixelFont);
    fill(0);
    textSize(65);
    text("Day 3", 140, 65);

    // Display ingredients with resize on hover method, visually appealing
    resizeOnHover(bottomBunImage, bottomBunX, bottomBunY, bottomBunWidth, bottomBunHeight, 1.5);
    resizeOnHover(topBunImage, topBunX, topBunY, topBunWidth, topBunHeight, 1.5);
    resizeOnHover(lettuceImage, lettuceX, lettuceY, lettuceWidth, lettuceHeight, 1.5);
    resizeOnHover(cheeseImage, cheeseX, cheeseY, cheeseWidth, cheeseHeight, 1.5);
    resizeOnHover(pattyImage, pattyX, pattyY, pattyWidth, pattyHeight, 1.5);
    resizeOnHover(tomatoImage, tomatoX, tomatoY, tomatoWidth, tomatoHeight, 1.5);
    resizeOnHover(onionImage, onionX, onionY, onionWidth, onionHeight, 1.5);
    
    // Transition into the final day
    if (day3FrameRate <= 200) {
      fill(0);
      rect(0, 0, width, height);
      fill(255);
      textAlign(CENTER, CENTER);
      textFont(pixelFont);
      textSize(100);
      text("Day 3", 410, 380);
      textSize(50);
      text("Farmers Harvest", 410, 475);
    } else {
      // If check to decrease fade alpha variable on draw method to create the transition
      if (fadeInScreenDay3 > 0) {
        fadeInScreenDay3 -= 2;
        fill(0, fadeInScreenDay3);
        rect(0, 0, width, height);
      }
    }   
    // Only starts countdown when the user is not in the main menu
    if (!inMainMenu) {
      countdown();
    }
  }

  public void winScreen() {
    // If check to decrease fade alpha variable on draw method to create the transition
    if (fadeInText < 255) {
      fadeInText += 2;
    }

    background(0);
    fill(255, fadeInText);
    textAlign(CENTER, CENTER);
    textFont(pixelFont);
    textSize(100);
    text("YOU WIN!!", 410, 380);
    textSize(25);
    text("Thank you for playing!", 410, 475);
    text("You had a rating of " + restaurantRating, 410, 520);
  }

  /**
   * Method to display the timer at the top of the screen during the game
   */
  public void countdown() {
    // Initialization of local variables, changing miliseconds to seconds and minutes, calculating time, etc
    int elapsedTime = millis() - startTime;
    int remainingTime = gameTimer * 1000 - elapsedTime;
    remainingTime = max(remainingTime, 0);
    int remainingSeconds = ceil(remainingTime / (float) 1000.0);
    int minutes = floor(remainingSeconds / 60);
    int seconds = remainingSeconds % 60;
  
    fill(0);
    textSize(60);
    text(nf(minutes, 2) + ":" + nf(seconds, 2), 383, 65);
  
    // If check to see if countdown has reached zero
    if (remainingTime <= 0) {
      // If check to decrease fade alpha variable on draw method to create loss transition
      if (fadeInText < 255) {
        fadeInText += 2;
      }

      background(0);
      fill(255, fadeInText);
      textAlign(CENTER, CENTER);
      textFont(pixelFont);
      textSize(30);
      text("The customers riotted,", 275, 350);
      text("you went out of business!", 510, 410);      
    }
  }

  /**
   * Method to draw stars in the ui at the top of the screen, uses for loop and some local variables
   * to manage the size, positioning and spacing between each stsar
   * @param rating Param entered is how much rating restaurant has, meaning how much stars it will draw
   */
  public void drawStars(int rating) {
    // Initialization of local variables for size and spacing
    int starSize = 30;
    int spacing = 17;
    
    for (int i = 0; i < rating; i++) {
      int x = 530 + i * (starSize + spacing);
      int y = 65;
      image(starRating, x, y, starSize, starSize);
    }
  }

  /**
   * Method to display the customers and speech bubbles above their heads with order
   */
  public void displayCustomers() {
    // If checks for if the transition in each day is done and if customer index is smaller than order array size
    if ((day1FrameRate > 400 || day2FrameRate > 400 || day3FrameRate > 300) && currentCustomerIndex < customerOrders.size()) {
      String[] orderIngredients = customerOrders.get(currentCustomerIndex);
      displaySpeechBubble(orderIngredients);

      // If check to see if the selected ingredients match the order, sets patience timer back to 0, adds to customer index and calls successful order method
      ArrayList<String> selectedIngredients = getCurrentOrder();
      if (containsAllIngredients(orderIngredients, selectedIngredients)) {
        successfulOrder();
        customerTimer = 0;
        currentCustomerIndex++;
      }

      customerTimer += 1000 / frameRate;

      // If check to make sure customer isn't impatient during fade, also resets customer timer
      if (customerTimer > impatienceTime && fadeInText == 0) {
        impatientCustomer();
        customerTimer = 0;
      }

      // If checks to check what index (/day) it is and draws customer based on the current index, calling the customer image method
      float customerX = 300;
      float customerY = 300;
      if (currentCustomerIndex < 5) {
        image(getCustomerImage(currentCustomerIndex), customerX, customerY, 240, 580);
      } else if (currentCustomerIndex >= 5 && currentCustomerIndex < 10) {
        image(getCustomerImage(currentCustomerIndex), customerX, customerY, 240, 580);
      } else if (currentCustomerIndex >= 10 && currentCustomerIndex < 15) {
        image(getCustomerImage(currentCustomerIndex), customerX, customerY, 240, 580);
      }

      // Calling patience bar method to draw the patience bar above customer
      float remainingPatience = max(0, 1 - customerTimer / (float) impatienceTime);
      drawPatienceBar(remainingPatience);
    }
  }

  /**
   * A method to check if the current selected ingredients match with the customers order,
   * returning true or false if it isn't
   * @param requiredIngredients String array containing all the ingredients
   * @param selectedIngredients String arraylist containing the selected ingredients
   * @return Returns boolean which tells program whether all the required ingredients are present
   */
  public boolean containsAllIngredients(String[] requiredIngredients, ArrayList<String> selectedIngredients) {
    for (String ingredient : requiredIngredients) {
        if (!selectedIngredients.contains(ingredient)) {
            return false;
        }
    }
    return true;
  }

  /**
   * Method to draw a speech bubble containing the ingredients that the customer wants on their burger
   * @param orderIngredients String array which contains the ingredients customer wants to order to display them in speech bubble
   */
  public void displaySpeechBubble(String[] orderIngredients) {
    // Initialization of local variables for positioning and sizing of speech bubble
    float speechBubbleX = 400;
    float speechBubbleY = 230;
    float speechBubbleWidth = 320;
    float speechBubbleHeight = 80;
    float ingredientX = speechBubbleX + 20;
    float ingredientY = speechBubbleY + 15;
    float ingredientSpacing = 60;

    image(speechBubble, speechBubbleX, speechBubbleY, speechBubbleWidth, speechBubbleHeight);

    // For loop to draw ingredients in speech bubble and checkmarks if the correct ingredient is selected
    for (String ingredient : orderIngredients) {

      PImage ingredientImage = getIngredientImage(ingredient);
      image(ingredientImage, ingredientX, ingredientY, 40, 30);

      // If check to see if correct ingredient is selected resulting in checkmark image over it
      if (isIngredientSelected(ingredient)) {
        image(checkMark, ingredientX + 25, ingredientY - 5, 20, 20);
      }

      ingredientX += ingredientSpacing;
    }
  }

  /**
   * Method to retrieve the customer image from the current customer index using switch statement and case for returning images
   * @param index Takes the current customer index resulting in returning of the image
   * @return Returns the image based on the index provided when the method is used in the display customers method to retrieve the image of the customer
   */
  public PImage getCustomerImage(int index) {
    switch (index) {
      case 0: return businessMan1;
      case 1: return businessMan2;
      case 2: return businessMan3;
      case 3: return businessMan4;
      case 4: return businessMan5;
      case 5: return casualMan1;
      case 6: return casualMan2;
      case 7: return casualMan3;
      case 8: return casualMan4;
      case 9: return casualMan5;
      case 10: return farmerMan1;
      case 11: return farmerMan2;
      case 12: return farmerWoman1;
      case 13: return farmerMan3;
      case 14: return farmerWoman2;
      default: return null;
    }
  }

  /**
   * Method similiar to get customer image method which will also use switch statement and case to return the images of the ingredients
   * @param ingredient String parameter for the ingredient which will result in image of it returned if it's in the switch statement cases
   * @return Returns an image of the ingredient based on the string provided in the parameter
   */
  public PImage getIngredientImage(String ingredient) {
    switch (ingredient) {
      case "Bottom Bun": return bottomBunImage;
      case "Top Bun": return topBunImage;
      case "Lettuce": return lettuceImage;
      case "Cheese": return cheeseImage;
      case "Onion": return onionImage;
      case "Patty": return pattyImage;
      case "Tomato": return tomatoImage;
      default: return null;
    }
  }

  /**
   * Method to get an ingredients X position based on the index provided
   * @param index integer parameter which takes index of ingredient to return its X position using switch statement and case
   * @return Returns the ingredients X position
   */
  public double getIngredientX(int index) {
    switch (index) {
      case 0: return bottomBunX;
      case 1: return topBunX;
      case 2: return lettuceX;
      case 3: return cheeseX;
      case 4: return onionX;
      case 5: return pattyX;
      case 6: return tomatoX;
      default: return 0;
    }
  }

  /**
   * Method to get an ingredients Y position based on the index provided
   * @param index integer parameter which takes index of ingredient to return its Y position using switch statement and case
   * @return Returns the ingredients Y position
   */
  public double getIngredientY(int index) {
    switch (index) {
      case 0: return bottomBunY;
      case 1: return topBunY;
      case 2: return lettuceY;
      case 3: return cheeseY;
      case 4: return onionY;
      case 5: return pattyY;
      case 6: return tomatoY;
      default: return 0;
    }
  }

  /**
   * Method to retrieve the ingredient width from index
   * @param index Index to return the width in order based on ingredient index given
   * @return Returns the width in the array for the ingredient width
   */
  public int getIngredientWidth(int index) {
    // Initialization of local variable, ingredient width array containing the widths for each ingredient in order
    int[] ingredientWidths = {73, 68, 77, 78, 74, 66, 76};
    return ingredientWidths[index];
  }
  
  /**
   * Method to retrieve the ingredient height from index
   * @param index Index to return the height in order based on ingredient index given
   * @return Returns the height in the array for the ingredient height
   */
  public int getIngredientHeight(int index) {
    // Initialization of local variable, ingredient height array containing the heights for each ingredient in order
    int[] ingredientHeights = {20, 37, 55, 45, 52, 44, 47};
    return ingredientHeights[index];
  }

  /**
   * Method to check if a specified ingredient is selected which is called in the speech bubble method
   * @param ingredient String parameter to check ingredient returning true or false whether it is selected
   * @return Returns true or false whether the given ingredient is selected or not
   */
  public boolean isIngredientSelected(String ingredient) {
    // For loop to check if the ingredient equals to the ingredient names in the array
    for (int i = 0; i < ingredientNames.length; i++) {
      if (ingredientNames[i].equals(ingredient)) {
        return ingredientSelected[i];
      }
    }
    return false;
  }
  
  /**
   * Method which calls clear order method
   */
  public void successfulOrder() {
    clearCurrentOrder();
  }

  /**
   * Method which decreases restaurant rating, resets customer timer and adds to the current customer index also calls clear current order
   */
  public void impatientCustomer() {
    restaurantRating--;
    currentCustomerIndex++;
    customerTimer = 0;
    clearCurrentOrder();
  }

  /**
   * Method which clears the current order by filling the ingredient selected array with false
   */
  public void clearCurrentOrder() {
    Arrays.fill(ingredientSelected, false);
  }

  /**
   * Method to check if mouse position is on ingredient, to see whether the ingredient is clicked
   * sets ingredientselected boolean and resets customer timer to replenish patience bar
   * also has else statement to minus rating and set wrong ingredient selected to true
   * in order to consequence the user for pressing wrong ingredient and flashing screen red
   */
  public void checkIngredientClicks() {
    for (int i = 0; i < ingredientSelected.length; i++) {
      double ingredientX = getIngredientX(i);
      double ingredientY = getIngredientY(i);
  
      if (isMousePressed && mouseX >= ingredientX && mouseX <= ingredientX + getIngredientWidth(i) && mouseY >= ingredientY && mouseY <= ingredientY + getIngredientHeight(i)) {
        if (isIngredientInCurrentOrder(getIngredientName(i))) {
          if (!ingredientSelected[i]) {
            ingredientSelected[i] = true;
            customerTimer = 0;
          }
        } else {
          wrongIngredientSelected = true;
          restaurantRating--;
        }
      }
    }
    isMousePressed = false;
  }
  
  /**
   * Method to return true or false given an string ingredient if the ingredient is in the current order or not
   * @param ingredient Param takes ingredient string to check if its in the current order
   * @return Returns true or false whether the ingredient is in the current order
   */
  public boolean isIngredientInCurrentOrder(String ingredient) {
    // Initialization of local variable, orderIngredients array 
    String[] orderIngredients = customerOrders.get(currentCustomerIndex);

    // For loop to check order ingredient array and ingredient param to return true or false whether ingredient is in current order
    for (String orderIngredient : orderIngredients) {
      if (orderIngredient.equals(ingredient)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Method to return an arraylist full of the ingredient names which are selected
   * @return Returns the order array
   */
  public ArrayList<String> getCurrentOrder() {
    // Initialization of local variable, order array
    ArrayList<String> order = new ArrayList<>();

    // For loop to check which ingredients have been selected to add name of it to the order array
    for (int i = 0; i < ingredientSelected.length; i++) {
      if (ingredientSelected[i]) {
        order.add(getIngredientName(i));
      }
    }
    return order;
  }
  
  /**
   * Method to get the ingredient names used in the check ingredient clicked method
   * @param index Param for the index to retrieve ingredient name from the names array
   * @return Returns an empty string if the index is invalid
   */
  public String getIngredientName(int index) {
    // If check to see if index is within the ingredient names array
    if (index >= 0 && index < ingredientNames.length) {
      return ingredientNames[index];
    } else {
      return "";
    }
  }
  
  /**
   * Method to draw the red patience bar over the customer
   * @param remainingPatience Param for the reamining amount of patience customer has
   */
  public void drawPatienceBar(float remainingPatience) {
    // Initialization of local variable for the filled bar width
    float barFillWidth = 320 * remainingPatience;
  
    // Drawing the bar
    fill(255, 50);
    rect(400, 200, barFillWidth, 10);
    fill(255, 0, 0);
    rect(400, 200, barFillWidth, 10);
  }
  
  /**
   * Method to resize an image when hovered over, very useful for design and making game look appealing
   * @param originalImage Param for the original image which is to be resized
   * @param x Param for the x of the image
   * @param y Param for the y of the image
   * @param originalWidth Param for the original width of the image
   * @param originalHeight Param for the original height of the image
   * @param scaleFactor Param for how much you want to resize the image
   */
  public void resizeOnHover(PImage originalImage, double x, double y, int originalWidth, int originalHeight, double scaleFactor) {
    double leftBound = x;
    double upperBound = y;
  
    // If check to see if mouse is hovered over the image
    if (mouseX >= leftBound && mouseX <= leftBound + originalWidth && mouseY >= upperBound && mouseY <= upperBound + originalHeight) {
      // Initialization of local variables for width, height, x and y positions
      int newWidth = (int) (originalWidth * scaleFactor);
      int newHeight = (int) (originalHeight * scaleFactor);
      double newX = (double) x - ((double) (newWidth - originalWidth) / 2.0);
      double newY = (double) y - ((double) (newHeight - originalHeight) / 2.0);      
  
      // Copies and resizes image
      PImage resizedImage = originalImage.copy();
      resizedImage.resize(newWidth, newHeight);

      // Displays resized image
      image(resizedImage, (float) newX, (float) newY);
    } else {
      // Displays image normally if not hovered over
      image(originalImage, (float) x, (float) y);
    }
  }
  
  /**
   * Built in mousepressed method to check if hovered over the cook text in menu to transition us to day 1
   * sets in main menu boolean and sets start time, also has else to set is mouse pressed to true
   */
  public void mousePressed() {
    if (inMainMenu) {
      if (mouseX > cookTextX && mouseX < cookTextX + cookTextWidth && mouseY > cookTextY && mouseY < cookTextY + cookTextHeight) {
        inMainMenu = false;
        startTime = millis(); // Reset the start time  
      }
    } else {
      isMousePressed = true;
    }
  }
}