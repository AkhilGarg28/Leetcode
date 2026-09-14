class Solution:
    def isRectangleOverlap(self, rec1: list[int], rec2: list[int]) -> bool:
        # Check if they do NOT overlap, then negate it
        return not (rec2[2] <= rec1[0] or  # rec2 is left of rec1
                    rec2[0] >= rec1[2] or  # rec2 is right of rec1
                    rec2[3] <= rec1[1] or  # rec2 is below rec1
                    rec2[1] >= rec1[3])    # rec2 is above rec1
