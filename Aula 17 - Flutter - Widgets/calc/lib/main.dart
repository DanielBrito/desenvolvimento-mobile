import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'My Calc'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  var number1Controller = TextEditingController();
  var number2Controller = TextEditingController();
  double result=0, number1, number2;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                Container(
                    width: 50,
                    child: TextField(
                      controller: number1Controller,
                      keyboardType: TextInputType.number,
                    ),
                    ),
                
                Container(
                    width: 50,
                    child: TextField(
                      controller: number2Controller,
                      keyboardType: TextInputType.number,
                    ),
                    ),
              ],
            ),
            Row(
              children: <Widget>[
               RaisedButton(
                      child: Text("+"),
                      onPressed: (){
                        setState(() {
                          result = double.parse(number1Controller.text) + double.parse(number2Controller.text);
                        });
                      },
                    ),
              RaisedButton(
                child: Text("-"),
                onPressed: (){
                  setState(() {
                    result = double.parse(number1Controller.text) - double.parse(number2Controller.text);
                  });
                },
              ),
              RaisedButton(
                      child: Text("*"),
                      onPressed: (){
                        setState(() {
                          result = double.parse(number1Controller.text) * double.parse(number2Controller.text);
                        });
                      },
                    ),
              RaisedButton(
                child: Text("/"),
                onPressed: (){
                  setState(() {
                    result = double.parse(number1Controller.text) / double.parse(number2Controller.text);
                  });
                },
              ),
              ],
            ),
            
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
              Text("Result: $result")
            ],)
          ],
        ),
      ),
    );
  }
}
