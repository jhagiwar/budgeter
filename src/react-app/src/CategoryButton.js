import React, { useState } from "react";

function CategoryButton() {
  const [active, setActive] = useState(false);
  function activateOnClick() {
    setActive(true);
  }

  if (active) {
    return ("Button has been Pressed")
  } else {
    return (
      <button className="category-button" onClick={activateOnClick}>Apple</button>
    )
  }
}

export default CategoryButton