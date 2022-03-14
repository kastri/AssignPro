import React, {useState} from 'react';

import {
  ScrollView,
  TextInput,
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
} from 'react-native';
import Calculation from '../components/CalculateComponent';

const Home = ({navigation}) => {
  const [firstNumber, setFirstNumber] = useState(0);
  const [secondNumber, setSecondNumber] = useState(0);
  const operations = ['+', '-', '/', '*'];
  return (
    <ScrollView style={styles.container}>
      <View>
        <TextInput
          style={styles.inputText}
          placeholder="Enter Frist number"
          keyboardType="numeric"
          value={firstNumber}
          onChangeText={value => setFirstNumber(value)}
        />
        <TextInput
          style={styles.inputText}
          placeholder="Enter Second number"
          keyboardType="numeric"
          value={secondNumber}
          onChangeText={value => setSecondNumber(value)}
        />

        <TouchableOpacity
          style={styles.submitButton}
          onPress={() => {
            if (!firstNumber || !secondNumber) {
              return;
            }
            var randomOperation =
              operations[(Math.random() * operations.length) | 0];
            const result = Calculation.getCalculationResult(
              randomOperation,
              Number(firstNumber),
              Number(secondNumber),
            );
            alert('result: ' + result + ' operation: ' + randomOperation);
          }}>
          <Text style={styles.textButton}>Submit</Text>
        </TouchableOpacity>

        <TouchableOpacity
          style={styles.submitButton}
          onPress={() => {
            navigation.navigate('WebViewScreen');
          }}>
          <Text style={styles.textButton}>Go To webView</Text>
        </TouchableOpacity>
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    backgroundColor: 'white',
    padding: 15,
    flex: 1,
  },
  submitButton: {
    alignSelf: 'center',
    borderColor: 'grey',
    borderWidth: 1,
    padding: 10,
    borderRadius: 7,
    minWidth: 220,
    marginTop: 10,
  },
  textButton: {
    alignSelf: 'center',
    fontSize: 16,
    fontWeight: '500',
  },
  inputText: {
    paddingVertical: 10,
    borderBottomColor: 'grey',
    borderBottomWidth: 1,
  },
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default Home;
