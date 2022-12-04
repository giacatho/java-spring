export default function Course({myCourse, handleCourseClick}) {
    return (
        <div>
            <div>{myCourse.name} <button onClick={e => handleCourseClick(myCourse.id)}>Details</button></div>        
        </div>
    )
}