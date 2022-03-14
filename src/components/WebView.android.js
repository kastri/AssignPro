'use strict';

import * as PropTypes from 'prop-types';
import * as React from 'react';
import {requireNativeComponent} from 'react-native';
import {WebView} from 'react-native-webview';

const CustomWebView = props => {
  return (
    <WebView
      {...props}
      source={{uri: props.url}}
      nativeConfig={{component: MyCustomWebView}}
    />
  );
};

CustomWebView.propTypes = {
  ...WebView.propTypes,
};

const MyCustomWebView = requireNativeComponent(
  'MyCustomWebView',
  CustomWebView,
  WebView.extraNativeComponentConfig,
);

export default CustomWebView;
