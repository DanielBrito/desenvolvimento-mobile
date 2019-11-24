import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'models/user.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Storage'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  var itens = new List<User>();
  MyHomePageConstrutor() {
    itens = [];
  }

  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  var name = TextEditingController();
  var username = TextEditingController();

  _MyHomePageState(){
    load();
  }

  load() async {
    var prefs = await SharedPreferences.getInstance();
    var data = prefs.getString('data');
    if (data != null) {
      Iterable decoded = jsonDecode(data);            
      List<User> listItens = decoded.map((x) => User.fromJson(x)).toList();
      setState(() {
        widget.itens = listItens;
      });
    }
  }

  save() async {
    var prefs = await SharedPreferences.getInstance();
    await prefs.setString('data', jsonEncode(widget.itens));
  }

  ListTile _tile(String username, String name) => ListTile(
        title: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Text(
              "Name: ",
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            Flexible(
              child: Text(name),
            ),
            Text(
              "Username: ",
              style: TextStyle(fontWeight: FontWeight.bold),
            ),
            Flexible(
              child: Text(username),
            ),
          ],
        ),
      );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: SingleChildScrollView(
        child: Column(
          children: <Widget>[
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                Flexible(
                  child: Text(
                    "Name: ",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                ),
                Flexible(
                  child: TextField(controller: name),
                )
              ],
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: <Widget>[
                Flexible(
                  child: Text(
                    "Username: ",
                    style: TextStyle(fontWeight: FontWeight.bold),
                  ),
                ),
                Flexible(
                  child: TextField(controller: username),
                )
              ],
            ),
            SizedBox(height: 30),
            RaisedButton(
              onPressed: () {
                setState(() {
                  widget.itens
                      .add(User(username: username.text, name: name.text));
                      save();
                });
                print(name.text + " " + username.text);
                name.clear();
                username.clear();
              },
              child: Text("Add"),
            ),
            ListView.builder(
                physics: const NeverScrollableScrollPhysics(),
                shrinkWrap: true,
                itemCount: widget.itens.length,
                itemBuilder: (BuildContext ctxt, int index) {
                  return _tile(
                      widget.itens[index].username, widget.itens[index].name);
                })
          ],
        ),
      ),
    );
  }
}
