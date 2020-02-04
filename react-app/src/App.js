import React, {Component} from 'react';
import ReactPaginate from 'react-paginate';
import UserInformation from "./components/user-information";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            userInfo: [],
            pageCount: 10
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
                <ReactPaginate
                    previousLabel={'previous'}
                    nextLabel={'next'}
                    breakLabel={'...'}
                    breakClassName={'break-me'}
                    pageCount={this.state.pageCount}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                    onPageChange={console.log("sdfsdfs")}
                    containerClassName={'pagination'}
                    subContainerClassName={'pages pagination'}
                    activeClassName={'active'}
                />
            </div>
        )
    }
}

export default App;
