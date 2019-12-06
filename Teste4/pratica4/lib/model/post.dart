class Post {
  int id;
  String user;
  String title;
  String body;

  Post({this.id, this.user, this.title, this.body});

  Post.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    user = json['user'];
    title = json['title'];
    body = json['body'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['user'] = this.user;
    data['title'] = this.title;
    data['body'] = this.body;
    return data;
  }
}