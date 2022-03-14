import React from 'react';

import {StyleSheet, View} from 'react-native';
import WebView from '../components/WebView';

const WebViewScreen = () => {
  return (
    <View style={{flex: 1}}>
      <WebView url="http://www.google.com" />
    </View>
  );
};

const styles = StyleSheet.create({
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

export default WebViewScreen;
