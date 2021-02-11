function AdminUserServiceClient() {
  this.createUser = createUser;
  this.findAllUsers = findAllUsers;
  this.findUserById = findUserById;
  this.deleteUser = deleteUser;
  this.updateUser = updateUser;
  this.url = 'https://wbdv-generic-server.herokuapp.com/api/001311078/users';
  var self = this;

  function createUser(user) {
    return fetch(self.url, {
      method: 'POST',
      headers: {
        'content-type': 'application/json'
      },
      body: JSON.stringify(user)
    })
    .then(function (response) {
      return response.json()
    })
  }

  function findAllUsers() {
    return fetch(self.url)
      .then(function (response) { //promise
        return response.json()
      })
  }

  function findUserById(userId) { //optional

  }

  function deleteUser(userId) { //promise
    return fetch(`${self.url}/${userId}`, {method: 'DELETE'}) // not "get"
    .then(function (response) {
      return response.json()
    })
  }

  function updateUser(userId, user) {
    return fetch(`${self.url}/${userId}`, {
      method: 'PUT',
      body: JSON.stringify(user),
      headers: {
        'content-type': 'application/json'
      }
    }).then(response => response.json())
  }
}
