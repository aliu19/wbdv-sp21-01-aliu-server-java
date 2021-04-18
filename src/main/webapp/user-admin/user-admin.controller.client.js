var $usernameFld
var $passwordFld
var $firstNameFld
var $lastNameFld
var $roleFld
var $updateBtn
var $createBtn
var $userRowTemplate
var $tbody
var userService = new AdminUserServiceClient()
var users
var selectedUser = null

// https://www.geeksforgeeks.org/how-to-clear-form-after-submit-in-javascript-without-using-reset/
function clearForm() {
  document.getElementById("usernameFld").value = ''
  document.getElementById("passwordFld").value = ''
  document.getElementById("firstNameFld").value = ''
  document.getElementById("lastNameFld").value = ''
  document.getElementById("roleFld").value = ''
}

function createUser() {
  var newUser = {
    username: $usernameFld.val(),
    password: $passwordFld.val(),
    firstName: $firstNameFld.val(),
    lastName: $lastNameFld.val(),
    role: $roleFld.val()
  }

  userService.createUser(newUser)
    .then(function (actualUser) {
      users.push(actualUser)
      renderUsers(users)
    })

  clearForm()
}

function deleteUser(event) {
  var button = $(event.target)
  var index = button.attr("id")
  var id = users[index]._id
  userService.deleteUser(id)
    .then(function (status) {
      users.splice(index, 1) // delete and re-rendering
      renderUsers(users) // only happens after confirmation from server
    })
}

function selectUser(event) {
  var id = $(event.target).attr("id")
  selectedUser = users.find(user => user._id === id)
  $usernameFld.val(selectedUser.username)
  $passwordFld.val(selectedUser.password)
  $firstNameFld.val(selectedUser.firstName)
  $lastNameFld.val(selectedUser.lastName)
  $roleFld.val(selectedUser.role)
}

function updateUser() {
  selectedUser.username = $usernameFld.val()
  selectedUser.password = $passwordFld.val()
  selectedUser.firstName = $firstNameFld.val()
  selectedUser.lastName = $lastNameFld.val()
  selectedUser.role = $roleFld.val()
  userService.updateUser(selectedUser._id, selectedUser)
    .then(status => {
      var index = users.findIndex(user => user._id === selectedUser._id)
      users[index] = selectedUser
      renderUsers(users)
    })

  clearForm()
}

function renderUsers(users) {
  $userRowTemplate.empty()
  for(var i=0; i<users.length; i++) {
    var user = users[i]
    $userRowTemplate
    .prepend(`
      <tr>
      <td class="wbdv-username">${user.username}</td>
      <td class="wbdv-password">${user.password}</td>
      <td class="wbdv-first-name">${user.firstName}</td>
      <td class="wbdv-last-name">${user.lastName}</td>
      <td class="wbdv-role">${user.role}</td>
      <td class="wbdv-actions">
        <span class="pull-right" style="white-space: nowrap">
          <button class="btn fa-2x fa fa-times wbdv-delete-btn" id="${i}"></button>
          <button class="btn fa-2x fa fa-pencil wbdv-select-btn" id="${user._id}"></button>
        </span>
      </td>
      </tr>
      `)
  }
  $(".wbdv-delete-btn").click(deleteUser)
  $(".wbdv-select-btn").click(selectUser)
}

function main() {
  $createBtn = $(".wbdv-create")
  $updateBtn = $(".wbdv-update")

  $usernameFld = $("#usernameFld")
  $passwordFld = $("#passwordFld")
  $firstNameFld = $("#firstNameFld")
  $lastNameFld = $("#lastNameFld")
  $roleFld = $("#roleFld")

  $tbody = $(".wbdv-tbody")
  $userRowTemplate = $("#userRowTemplate")

  $createBtn.click(createUser)
  $updateBtn.click(updateUser)

  userService.findAllUsers() // gets users from server
    .then(function (actualUsers) {
      users = actualUsers
      renderUsers(users); // renders those users
    })
}
jQuery(main);