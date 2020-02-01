import React, {Component} from 'react';
import UserInformation from "./components/user-information";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userInfo: []
        };
        this.searchUserList = this.searchUserList.bind(this);
        console.log("App constructor.");
    }

    componentDidMount() {
        console.log("Finished rendering App onto DOM.");
    }

    searchUserList() {
        fetch('http://localhost:8080/api/v1/users')
            .then(res => res.json())
            .then((data) => {
                this.setState({userInfo: data})
            })
            .catch(console.log)
    }

    render() {
        return (
            <div>
                <h1 align="center">User List</h1>
                <button onClick={this.searchUserList}>Search</button>
                <UserInformation userInfo={this.state.userInfo}/>
            </div>
        )
    }
}

export default App;
