import logo from './logo.svg';
import './App.css';
import Course from './Course';
import ListCourse from './ListCourse';

function App() {
  const courseList = [{
    id: 1,
    code: 'FOPCS',
    name: 'Fundamental of Programming in C Sharp',
    description: 'FOPCS description' 
  },
  {
    id: 2,
    code: 'OOPCS',
    name: 'Object Oriented Programming',
    description: 'OOPCS description' 
  }];


  return (
    <div>
      <h2>My Course List</h2>
      <ListCourse myCourseList={courseList} />
    </div>
  );
}

export default App;
