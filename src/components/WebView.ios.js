import React from 'react';
import {WebView} from 'react-native-webview';

const WebViewComponent = ({url}) => {
  return <WebView source={{uri: url}} />;
};

export default WebViewComponent;
