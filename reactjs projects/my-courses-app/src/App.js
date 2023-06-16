import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import CreateCourse from './CreateCourse';
import ListCourse from './ListCourse';

function App() {
  function getNavigationHtml() {
    return (
      <nav className="py-2 bg-light border-bottom">
        <div className="container d-flex flex-wrap">
          <ul className="nav me-auto">
            <li className="nav-item">
              <Link className="nav-link" to={"/"}>Home</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/list-course"}>Courses</Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to={"/create-course"}>Create</Link>
            </li>
          </ul>
        </div>
      </nav>
    )
  }
    


  return (
    <BrowserRouter>
      {getNavigationHtml()}
      <h2>Course Management</h2>
      <Routes>
        <Route path="/list-course"
          element={<ListCourse />} />
        <Route path="/create-course"
          element={<CreateCourse />} />
        <Route path="/" element={<ListCourse />} />
      </Routes>
    </BrowserRouter>

  );
}

export default App;