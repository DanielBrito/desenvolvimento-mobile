import 'package:flutter/material.dart';
import 'package:toast/toast.dart';
import 'rest.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Login',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Login'),
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
  var loginInput = TextEditingController();
  var senhaInput = TextEditingController();

  String login = "admin";
  String senha = "123456";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              "Login: ",
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            Container(
              width: 150,
              child: TextField(
                controller: loginInput,
                keyboardType: TextInputType.text,
              ),
            ),
            SizedBox(height: 30),
            Text(
              "Senha: ",
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            Container(
              width: 150,
              child: TextField(
                controller: senhaInput,
                keyboardType: TextInputType.number,
                obscureText: true,
              ),
            ),
            SizedBox(height: 60),
            RaisedButton(
              onPressed: () {
                if(loginInput.text!=login && senhaInput.text!=senha){
                  showToast("Usuário não encontrado!", gravity: Toast.BOTTOM);
                }
                else{
                  Navigator.push(
                    context, MaterialPageRoute(builder: (context) => Rest()));
                }
              },
              child: Text("LOGIN"),
            ),
          ],
        ),
      ),
    );
  }

  void showToast(String msg, {int duration, int gravity}) {
    Toast.show(msg, context, duration: duration, gravity: gravity);
  }
}
