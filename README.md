# Graph-Based Word Prediction System

## Project Overview

### Project Planning

**Goal:**
- Create a system that predicts the next word based on user input using a graph-based approach.

**Requirements:**
- **Input:** A sequence of words from the user.
- **Output:** Predicted next word.
- **Performance:** Handle large text data efficiently.
- **Usability:** Simple and intuitive user interface.

### Directories and Files

**`data/text_data.txt`**
  - **Description:** Contains the text data used to build the prediction model. This is the input file that the application will read, preprocess, and use to create the graph of word transitions.
  - **Note:** I didnt provide any data in this file. You need to provide your own text data for training.


**`src/main/java/com/prediction/App.java`**
  - **Description:** The main entry point of the application. This file:
    - Loads and preprocesses the text data.
    - Builds the graph of word transitions.
    - Provides a command-line interface for user interaction.
    - Takes user input and uses the `Predictor` class to predict and display the next word.

**`src/main/java/com/prediction/Graph`**
  - **Description:** Represents the graph data structure. This directory:
    - Contains methods to add edges between words and increment the weight of existing edges.
    - Provides a method to get the most likely next word based on the highest edge weight.

**`src/main/java/com/prediction/Preprocessor.java`**
  - **Description:** Handles text preprocessing. This file:
    - Contains a method to read text data from a file.
    - Converts the text to lowercase and removes non-alphabetic characters.

**`src/main/java/com/prediction/Predictor.java`**
  - **Description:** Contains the prediction logic. This file:
    - Uses the graph to predict the next word.
    - Provides a method to get the next word based on the current sequence of words input by the user.

**`.gitignore`**

**`README.md`**

### Data Collection and Preprocessing

**Gather Text Data:**
- Collect a large text corpus.

**Preprocess Text Data:**
- Convert text to lowercase.
- Remove non-alphabetic characters.

### Graph Construction

**Initialize the Graph:**
- Create an empty graph structure.

**Build the Graph:**
- Traverse the text data word by word.
- Create vertices for each word.
- Add edges between consecutive words with weights representing the frequency of transitions.

### Prediction Algorithm

**Prediction Logic:**
- When given a sequence of words, look up the corresponding vertices in the graph.
- Identify connected vertices (next words).
- Use edge weights to predict the next word based on frequency.

### User Interface

**Simple UI:**
- Command-line interface.
- Input field for user to type a sequence of words.
- Display the predicted next word.

### Testing and Evaluation

**Test the System:**
- Validate with different text inputs.
- Check the accuracy of predictions. (Still working on it)

**Optimize Performance:**
- Ensure the system handles large text efficiently. (Still working on it)


## Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/word-prediction.git
   cd word-prediction
   ```

## Run the application:
   ```sh
  javac src/main/java/com/prediction/Graph/*.java
  javac src/main/java/com/prediction/*.java
  java -cp src/main/java com.prediction.App
  ```
## Usage
  Run the application and input a sequence of words to get the predicted next word.
  Type exit to quit the application.

## Contributing
  Feel free to fork this project, submit issues, and make pull requests.
