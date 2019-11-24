import 'package:flutter/material.dart';

class Second extends StatefulWidget {
  String data;
  Second({@required this.data});
  @override
  _SecondState createState() => _SecondState();
}

class _SecondState extends State<Second> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Hello!",
      home: Scaffold(
        appBar: AppBar(
          title: Text("Second"),
        ),
        body: Center(
          child: Text(widget.data),
        ),
      ),
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),      
    );
  }
}