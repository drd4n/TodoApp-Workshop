import React, { useEffect, useState } from 'react'
import { Fragment } from "react";

export const TodoItems = (props) => {

        const [todoItem, setTodoItem] = useState(props.data)
        const [isDirty, setDirty] = useState(false);
        //object destructering การแตก object จากที่ไหนก็ตาม เผื่อเปลี่ยนแค่บางอย่างในนั้น
        // function updateIsDone() {
        // setTodoItem({...todoItem, isDone : !todoItem.isDone})
        //               อันเก่า                      อันใหม่
        //มันจะ set ตัวมันเองให้เป็นค่าใหม่ ซึ่งอันที่ไม่เปลี่ยนก็เอาค่าเก่ามาทับ (เหมือน constructer)
        // }

        useEffect(() => {
                if (isDirty) {
                        fetch(`http://localhost:8080/api/todoItems/${todoItem.id}`, {
                                method: 'PUT',
                                headers: {
                                        "content-type": "application/json"
                                },
                                body: JSON.stringify(todoItem)
                        }).then(response => response.json()).then(data => {
                                setDirty(false);
                                setTodoItem(data);
                        })
                console.log("todoItem changed")
                }
                
        }, [todoItem, isDirty])

        return (
                <Fragment>
                        <input
                                type="checkbox"
                                checked={todoItem.isDone}
                                onChange={() => {
                                         setDirty(true);
                                         setTodoItem({ ...todoItem, isDone: !todoItem.isDone })
                                                }
                                        } />
                        <span>{todoItem.task}</span>
                </Fragment>
        )
}

