# Character Prediction System

## Project Overview

### Project Planning

**Goal:**
- Create a system that predicts the next character based on user input using a graph-based approach.

**Requirements:**
- **Input:** A character from the user.
- **Output:** Predicted next character.
- **Performance:** Handle large text data efficiently.
- **Usability:** Simple and intuitive user interface.
  
##  Directory Structure
character-prediction/
├── data/
│   └── text_data.txt
├── src/
│   ├── __init__.py
│   ├── preprocess.py
│   ├── graph_builder.py
│   ├── predictor.py
│   └── app.py
├── tests/
│   ├── test_preprocess.py
│   ├── test_graph_builder.py
│   └── test_predictor.py
├── .gitignore
├── README.md
└── requirements.txt

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
  python src/app.py
  ```

## Usage
  Run the application and input a character to get the predicted next character.
  Type exit to quit the application.

## Contributing
  Feel free to fork this project, submit issues, and make pull requests.
