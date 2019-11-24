import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart';
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

  // REST:

  var url = 'https://jsonplaceholder.typicode.com/users';
  makeGetAll() async {
    final response = await get(url);
    if (response.statusCode == 200) {
      Iterable l = jsonDecode(response.body);
      List<User> users = l.map((i) => User.fromJson(i)).toList();
      setState(() {
        widget.itens = users;
      });
      for (var item in users) {
        print(item.username);
      }
    } else {
      throw Exception('Failed - get all');
    }
  }

  makeGetId(int i) async {
    final response = await get(url + "/$i");
    if (response.statusCode == 200) {
      var user = User.fromJson(jsonDecode(response.body));
      print("ID " + (i.toString()) + " = " + user.username);
    } else {
      throw Exception('Failed - get');
    }
  }

  makePost(User user) async {
    final response = await post(url, body: user.toJson());
    if (response.statusCode == 201) {
      var user2 = User.fromJson(jsonDecode(response.body));
      print(user2.username);
    } else {
      // If that response was not OK, throw an error.
      throw Exception('Failed - post');
    }
  }

  makePut(int i, User user) async {
    final response = await put(url + "/$i", body: user.toJson());
    if (response.statusCode == 200) {
      var user2 = User.fromJson(jsonDecode(response.body));
      print(user2.username);
    } else {
      // If that response was not OK, throw an error.
      throw Exception('Failed - put');
    }
  }

  makeDelete(int i) async {
    final response = await delete(url + "/$i");
    if (response.statusCode == 200) {
      print("Deletado");
    } else {
// If that response was not OK, throw an error.
      throw Exception('Failed to load post');
    }
  }

  _MyHomePageState() {
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
            SizedBox(height: 10),
            RaisedButton(
                child: Text("REST"),
                onPressed: () {
                  makeGetAll();
                  makeGetId(5);
                  makePost(User(username: username.text, name: name.text));
                  makePut(1, User(username: username.text, name: name.text));
                  makeDelete(9);
                }),
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
