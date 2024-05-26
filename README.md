# Graph-Based Prediction System

## Project Overview

### Project Planning

**Goal:**
- Create a system that predicts the next character based on user input using a graph-based approach.

**Requirements:**
- **Input:** A character from the user.
- **Output:** Predicted next character.
- **Performance:** Handle large text data efficiently.
- **Usability:** Simple and intuitive user interface.
  

### Directories and Files

**`data/text_data.txt`**
  - **Description:** Contains the text data used to build the prediction model. This is the input file that the application will read, preprocess, and use to create the graph of character.

**`src/main/java/com/prediction/App.java`**
  - **Description:** The main entry point of the application. This file:
  - Loads and preprocesses the text data.
  - Builds the graph of character transitions.
  - Provides a command-line interface for user interaction.
  - Takes user input and uses the `Predictor` class to predict and display the next character.

**`src/main/java/com/prediction/Graph`**
  - **Description:** Represents the graph data structure. This directory:
  - Contains methods to add edges between characters and increment the weight of existing edges.
  - Provides a method to get the most likely next character based on the highest edge weight.

**`src/main/java/com/prediction/Preprocessor.java`**
  - **Description:** Handles text preprocessing. This file:
  - Contains a method to read text data from a file.
  - Converts the text to lowercase and removes non-alphabetic characters.

**`src/main/java/com/prediction/Predictor.java`**
  - **Description:** Contains the prediction logic. This file:
  - Uses the graph to predict the next character.
  - Provides a method to get the next character based on the current character input by the user.

**`src/test/java/com/prediction/GraphTest.java`**
  - **Description:** Contains unit tests for the `Graph` class to ensure that:
  - Edges are added correctly.
  - Weights are incremented properly.
  - The most likely next character is returned based on the highest edge weight.

**`src/test/java/com/prediction/PreprocessorTest.java`**
  - **Description:** Contains unit tests for the `Preprocessor` class to ensure that:
  - Text data is correctly read from a file.
  - Text is converted to lowercase.
  - Non-alphabetic characters are removed.

**`src/test/java/com/prediction/PredictorTest.java`**
  - **Description:** Contains unit tests for the `Predictor` class to ensure that:
  - The prediction logic correctly identifies the next character based on the current character.
  - The integration between `Predictor` and `Graph` works as expected.

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
- Traverse the text data character by character.
- Create vertices for each character.
- Add edges between consecutive characters with weights representing the frequency of transitions.

### Prediction Algorithm

**Prediction Logic:**
- When given a character, look up the corresponding vertex in the graph.
- Identify connected vertices (next characters).
- Use edge weights to predict the next character based on frequency.

### User Interface

**Simple UI:**
- Command-line interface or a basic web interface.
- Input field for user to type a character.
- Display the predicted next character.

### Testing and Evaluation

**Test the System:**
- Validate with different text inputs.
- Check the accuracy of predictions.

**Optimize Performance:**
- Ensure the system handles large text efficiently.

### Documentation and Deployment


## Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/character-prediction.git
   cd character-prediction
   ```
## Run the application:
   ```sh
  execution
  ```

## Usage
  Run the application and input a character to get the predicted next character.
  Type exit to quit the application.

## Contributing
  Feel free to fork this project, submit issues, and make pull requests.
