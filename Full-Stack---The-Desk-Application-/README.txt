Documentation of changes in chronological order:
1. Moved addSampleExpenses() and the ArrayLists to the top of Main
2. Deleted closeApp() and replaced the call in case 6 with the original method println
3. Added a scanner to searchExpenses() so it can partially work
4. Deleted the second for and if statements from optionsSelection()
5. Not a fixed bug, but out of personal preference, I put the optionsSelection's for and if statements into a while loop. I prefer having the entries loop till I say stop, versus the original looping because it was recursively called
6. Worked on completing sortExpenses. Decided on using a Merge Sort, so I included a mergeSort method in addition to filling the sortExpenses method. sortExpenses splits the array down till it reaches one value. It then compares the values in mergeSort, working its way back up to the top. This results in two sorted lists right before the final pass through mergeSort. The final pass combines these two sorted lists to the result desired
7. Implemented addSampleExpenses() to the main method
8. Deleted arrList and all respective code. It has no use
9. Might or might not be a bug, but depending on the desired functionality of the program, expense changes aren't saved once the program shuts down. Once the program boots up, it reverts to the default sample expenses. I didn't change this, but it would require file reading at the very simplest level to have changes permanently saved
10. Completed searchExpenses by utilizing indexOf
11. Included intChecker method. It checks if the user's entry is numeric. This if/else code could be copy/pasted into every place there is user input, but that is redundant, which is the primary reason I made this method. Called this method where needed
12. Deleted leng variable from searchExpenses and moved the println to its respective case