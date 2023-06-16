import React from 'react'

export default function CourseDetail({detailCourse}) {
  return (
    <div>
      <h4>Detail Course</h4>
      <div>Code: {detailCourse.code}</div>
      <div>Name: {detailCourse.name}</div>
      <div>Description: {detailCourse.description}</div>
    </div>
  )
}