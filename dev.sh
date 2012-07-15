#!/bin/bash
git pull https://github.com/railgunlv5/Poly_Thinking
git add -A

echo " input your comment: "
read cmt
git commit -m $cmt
git push -u origin
