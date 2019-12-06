import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import 'model/post.dart';

class Rest extends StatefulWidget {
  var posts = new List<Post>();
  Rest() {
    posts = [];
  }
  @override
  _RestState createState() => _RestState();
}

class _RestState extends State<Rest> {
  var idInput = TextEditingController();
  var userInput = TextEditingController();
  var titleInput = TextEditingController();
  var bodyInput = TextEditingController();

  _RestState(){
    load();
  }

  load() async {
    var prefs = await SharedPreferences.getInstance();
    var data = prefs.getString('data');
    if (data != null) {
      Iterable decoded = jsonDecode(data);            
      List<Post> listItens = decoded.map((x) => Post.fromJson(x)).toList();
      setState(() {
        widget.posts = listItens;
      });
    }
  }

  save() async {
    var prefs = await SharedPreferences.getInstance();
    await prefs.setString('data', jsonEncode(widget.posts));
  }

  ListTile _tile(int id, String user, String title, String body) => ListTile(
        title: Row(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: <Widget>[
            Flexible(
              child: Text(id.toString()),
            ),
            Flexible(
              child: Text(user),
            ),
            Flexible(
              child: Text(title),
            ),
            Flexible(
              child: Text(body),
            ),
          ],
        ),
      );

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "REST",
      home: Scaffold(
        appBar: AppBar(
          title: Text("REST"),
        ),
        body: SingleChildScrollView(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            SizedBox(height: 20),
            Container(
              width: 150,
              child: TextField(
                controller: idInput,
                keyboardType: TextInputType.number,
                decoration: new InputDecoration.collapsed(hintText: 'Id'),
              ),
            ),
            SizedBox(height: 20),
            Container(
              width: 150,
              child: TextField(
                controller: userInput,
                keyboardType: TextInputType.text,
                decoration: new InputDecoration.collapsed(hintText: 'Username'),
              ),
            ),
            SizedBox(height: 20),
            Container(
              width: 150,
              child: TextField(
                controller: titleInput,
                keyboardType: TextInputType.text,
                decoration: new InputDecoration.collapsed(hintText: 'Title'),
              ),
            ),
            SizedBox(height: 20),
            Container(
              width: 150,
              child: TextField(
                controller: bodyInput,
                keyboardType: TextInputType.number,
                decoration: new InputDecoration.collapsed(hintText: 'Post'),
              ),
            ),
            SizedBox(height: 30),
            Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: <Widget>[
                  Flexible(
                      child: RaisedButton(
                          onPressed: () {
                              setState(() {
                                widget.posts.add(Post(
                                    id: int.parse(idInput.text), user: userInput.text, title: titleInput.text, body: bodyInput.text));
                                    save();
                              });
                          },
                          child: Text("ADD"))),
                  Flexible(
                      child: RaisedButton(
                          onPressed: () {
                            setState(() {
                              // MÉTODO GET
                            });
                          },
                          child: Text("GET"))),
                ]),
            SizedBox(height: 20),
            ListView.builder(
                physics: const NeverScrollableScrollPhysics(),
                shrinkWrap: true,
                itemCount: widget.posts.length,
                itemBuilder: (BuildContext ctxt, int index) {
                  return _tile(widget.posts[index].id, widget.posts[index].user,
                      widget.posts[index].title, widget.posts[index].body);
                })
          ],
        )
        ),
      ),
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
    );
  }
}
