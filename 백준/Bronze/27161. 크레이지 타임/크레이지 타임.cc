#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>
#include <unordered_map>

void solve() {

	int n;
	std::cin >> n;

	int start = 0;
	bool isReverse = false;
	while (n--) {
		std::string s;
		int time;

		std::cin >> s >> time;

		if (start == 0) {
			start = 1;
		}
		else if (isReverse) {
			if (start == 1) {
				start = 12;
			}
			else {
				start--;
			}
		}
		else {
			if (start == 12) {
				start = 1;
			}
			else {
				start++;
			}
		}

		std::string slap = "NO";
		if (s == "HOURGLASS" && time == start) {
			slap = "NO";
		}
		else if (s == "HOURGLASS") {
			isReverse = !isReverse;
		}
		else if (time == start) {
			slap = "YES";
		}

		std::cout << start << " " << slap << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}