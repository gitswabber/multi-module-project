import React, {Component} from 'react';
import Contacts from "./components/contacts";

class App extends Component {
  render() {
    return (
        <Contacts contacts={this.state.contacts}/>
/*        <div className="card">
          <div className="card-body">
            <h5 className="card-title">Steve Jobs</h5>
            <h6 className="card-subtitle mb-2 text-muted">steve@apple.com</h6>
            <p className="card-text">Stay Hungry, Stay Foolish</p>
          </div>
        </div>*/
    )
  }

  state = {
      contacts: []
  }

  componentDidMount() {
      // fetch('http://localhost:8080/hello')
      fetch('http://jsonplaceholder.typicode.com/users')
          .then(res => res.json())
          .then((data) => {
              this.setState({contacts: data})
          })
          .catch(console.log)
  }
}

export default App;
