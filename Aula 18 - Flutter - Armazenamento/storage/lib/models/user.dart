class User {
  String name;
  String username;

  User({this.name, this.username});

  User.fromJson(Map<String, dynamic> json) {
    name = json['name'];
    username = json['username'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['name'] = this.name;
    data['username'] = this.username;
    return data;
  }
}